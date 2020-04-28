<?php
require("../database/dbh.inc.php");
require("../files/upload_image.inc.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";
	if(isset($_POST["serial_id"])&& isset($_POST["company_name"]) && isset($_POST["pincode"]) && isset($_POST["address"]) && isset($_POST["password"])){
		$serial_id = mysqli_real_escape_string($conn, $_POST["serial_id"]);
		$company_name = mysqli_real_escape_string($conn, $_POST["company_name"]);
		$pincode = mysqli_real_escape_string($conn, $_POST["pincode"]);
		$address = mysqli_real_escape_string($conn, $_POST["address"]);
		$password = mysqli_real_escape_string($conn, $_POST["password"]);
		if(empty($serial_id) || empty($company_name) || empty($pincode)|| empty($address)|| empty($password)){
			$message["error"] = true;
			$message["error_message"] = "Invalid parameters";
			die(json_encode($message));	
		}else{
			if(!is_numeric($serial_id) || !preg_match('/^[0-9]{6}+$/', $pincode)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";
				die(json_encode($message));
			}else{
				$hash_password = password_hash($password, PASSWORD_DEFAULT);
				$stmt = $conn->prepare("INSERT INTO users (company_name, pincode, address, credential_id, password) VALUES (?, ?, ?, ?, ?)");
				$stmt->bind_param("sisis", $company_name, $pincode, $address, $serial_id, $hash_password);
				$stmt->execute();
				$stmt->close();
				$message["error"] = false;
				$message["error_message"] = "Success";
				die(json_encode($message));
			}
		}
	}
	die(json_encode($message));
?>