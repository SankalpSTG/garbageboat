<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["address"])&& isset($_POST["pincode"])){
		$address = mysqli_real_escape_string($conn, $_POST["address"]);
		$pincode = mysqli_real_escape_string($conn, $_POST["pincode"]);
		if(empty($address) || empty($pincode)){
			$message["error"] = true;
			$message["error_message"] = "Invalid parameters";
			die(json_encode($message));	
		}else{
			if(!is_string($address) || !preg_match('/^[0-9]{6}+$/', $pincode)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";
			die(json_encode($message));
			}else{
				$stmt = $conn->prepare("INSERT INTO users (address, pincode) VALUES (?, ?)");
				$stmt->bind_param("si", $address, $pincode);
				$stmt->execute();
				$stmt->close();
				$message["error"] = false;
				$message["error_message"] = "Success";
				die(json_encode($message));	
			}
		}
	}die(json_encode($message));
?>