<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"]) && isset($_POST["email_id"])){
		$serial_id = (int) $_POST["serial_id"];
		$email_id = mysqli_real_escape_string($conn, $_POST["email_id"]);
		if(empty($serial_id) || empty($email_id)){
			$message["error"] = true;
			$message["error_message"] = "Invalid parameters";
			die(json_encode($message));	
		}else{
			if(!is_numeric($serial_id) || (filter_var($email_id, FILTER_VALIDATE_EMAIL)== false)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";
			die(json_encode($message));
			}else{
				$stmt = $conn->prepare("UPDATE credentials SET email_id = ? WHERE serial_id = ?");
				$stmt->bind_param("si", $email_id, $serial_id);
				$stmt->execute();
				$stmt->close();
				$message["error"] = false;
				$message["error_message"] = "Success";
				die(json_encode($message));	
			}
		}
	}die(json_encode($message));
?>