<?php
require ("../database/dbh.inc.php");
require ("../other/encdec.php");
		$x =0;
	while ($x <=100){
		$user = generateRandomString(10);
		$company_name = generateRandomString(7);
		$password = generateRandomString(6);
		$address = generateRandomString(12);
		$pincode = generateOtp(6);
		$mobile_no = generateOtp(10);
		$email_id = $user . '@email.com';
		
		$stmt = $conn->prepare("INSERT INTO credentials (email_id, mobile_no) VALUES (?, ?)");
		$stmt->bind_param("si", $email_id, $mobile_no);
		$stmt->execute();
		$stmt->close();
		$stmt = $conn->prepare("SELECT serial_id FROM credentials WHERE email_id = ?");
		$stmt->bind_param("s", $email_id);
		$stmt->execute();
		$result = $stmt->get_result();
		$row = mysqli_fetch_assoc($result);
		$stmt->close();
		$serial_id = (int)$row["serial_id"];
		$hash_password = password_hash($password, PASSWORD_DEFAULT);
		$stmt = $conn->prepare("INSERT INTO users (company_name, pincode, address, credential_id, password) VALUES (?, ?, ?, ?, ?)");
		$stmt->bind_param("sisis", $company_name, $pincode, $address, $serial_id, $hash_password);
		$stmt->execute();
		$stmt->close();
		echo 'success';
		$x++;
	}
?>