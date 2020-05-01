<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	$stmt = $conn->prepare("SELECT cred.serial_id, cred.email_id, cred.mobile_no, cred.account_level, cred.verification_level, usr. company_name, usr.logo_url, usr.address, usr.pincode FROM credentials as cred, users as usr WHERE cred.account_level = 0 and usr.credential_id = cred.serial_id limit 10");
	$stmt->execute();
	$result = $stmt->get_result();
	$stmt->close();
	if(mysqli_num_rows($result) > 0){
		$data = [];
		while ($row = mysqli_fetch_assoc($result)){
		$responce = [];
		$responce["serial_id"] = (int)$row["serial_id"];
		$responce["email_id"] = (string)$row["email_id"];
		$responce["mobile_no"] = (int)$row["mobile_no"];
		$responce["account_level"] = (int)$row["account_level"];
		$responce["verification_level"] = (int)$row["verification_level"];
		$responce["company_name"] = (string)$row["company_name"];
		$responce["logo_url"] = (string)$row["logo_url"];
		$responce["pincode"] = (int)$row["pincode"];
		$responce["address"] = (string)$row["address"];
		array_push($data, $responce);
		}
		$message["data"] = $data;
		$message["error"] = false;
		$message["error_message"] = "Success";	
		die(json_encode($message));
	}else{
		$message["error"] = true;
		$message["error_message"] = "No user found";	
		die(json_encode($message));
	}die(json_encode($message));
?>