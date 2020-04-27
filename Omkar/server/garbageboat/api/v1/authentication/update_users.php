<?php
require("../database/dbh.inc.php");
require("../files/upload_image.inc.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";
	if(isset($_POST["email_id"])&& isset($_POST["company_name"]) && isset($_POST["pincode"]) && isset($_POST["address"]) && isset($_POST["password"])){
		$email_id = mysqli_real_escape_string($conn, $_POST["email_id"]);
		$company_name = mysqli_real_escape_string($conn, $_POST["company_name"]);
		$pincode = mysqli_real_escape_string($conn, $_POST["pincode"]);
		$address = mysqli_real_escape_string($conn, $_POST["address"]);
		$password = mysqli_real_escape_string($conn, $_POST["password"]);
		if(empty($email_id) || empty($company_name) || empty($pincode)|| empty($address)|| empty($password)){
			$message["error"] = true;
			$message["error_message"] = "Invalid parameters";
			die(json_encode($message));	
		}else{
			if((filter_var($email_id, FILTER_VALIDATE_EMAIL) === false) ||  !preg_match('/^[0-9]{6}+$/', $pincode) || !preg_match('/^(?=.*\d)(?=.*[@#\-_$%^&+=§!\?])(?=.*[a-z])(?=.*[A-Z])[0-9A-Za-z@#\-_$%^&+=§!\?]{8,20}$/',$password)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";
				die(json_encode($message));
			}else{
				$stmt = $conn->prepare("SELECT serial_id FROM credentials WHERE email_id = ?");
				$stmt->bind_param("s", $email_id);
				$stmt->execute();
				$result = $stmt->get_result();
				$stmt->close();
				if(mysqli_num_rows($result) == 1){
					$row = mysqli_fetch_assoc($result);
					$serial_id = $row["serial_id"];
					$row = mysqli_fetch_assoc($result);
					$hash_password = password_hash($password, PASSWORD_DEFAULT);
					$stmt = $conn->prepare("INSERT INTO users (company_name, pincode, address, credential_id, password) VALUES (?, ?, ?, ?, ?)");
					$stmt->bind_param("sisis", $company_name, $pincode, $address, $serial_id, $hash_password);
					$stmt->execute();
					$stmt->close();
					$message["error"] = false;
					$message["error_message"] = "Success";
					die(json_encode($message));
				}else{
					$message["error"] = true;
					$message["error_message"] = "User is not exist";
					die(json_encode($message));
				}
			}
		}			
	
	}
	die(json_encode($message));
?>