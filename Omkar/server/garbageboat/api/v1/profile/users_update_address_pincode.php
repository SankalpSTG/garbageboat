<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"]) && isset($_POST["address"])&& isset($_POST["pincode"])){
		$serial_id = mysqli_real_escape_string($conn, $_POST["serial_id"]);
		$address = mysqli_real_escape_string($conn, $_POST["address"]);
		$pincode = mysqli_real_escape_string($conn, $_POST["pincode"]);
		if(empty($serial_id) || empty($address) || empty($pincode)){
			$message["error"] = true;
			$message["error_message"] = "Invalid parameters";
			die(json_encode($message));	
		}else{
			if(!is_numeric($serial_id) || !preg_match('/^[0-9]{6}+$/', $pincode)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";
			die(json_encode($message));
			}else{
				$stmt = $conn->prepare("UPDATE users SET address = ?, pincode = ? WHERE credential_id = ?");
				$stmt->bind_param("sii", $address, $pincode, $serial_id);
				$stmt->execute();
				$stmt->close();
				$message["error"] = false;
				$message["error_message"] = "Success";
				die(json_encode($message));	
			}
		}
	}die(json_encode($message));
?>