<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"]) && isset($_POST["password"])){
		$serial_id = mysqli_real_escape_string($conn, $_POST["serial_id"]);
		$password = mysqli_real_escape_string($conn, $_POST["password"]);
		if(empty($serial_id) || empty($password)){
			$message["error"] = true;
			$message["error_message"] = "Invalid parameters";
			die(json_encode($message));	
		}else{
			if(!is_numeric($serial_id) || !preg_match('/^(?=.*\d)(?=.*[@#\-_$%^&+=ยง!\?])(?=.*[a-z])(?=.*[A-Z])[0-9A-Za-z@#\-_$%^&+=ยง!\?]{8,20}$/',$password)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";
			die(json_encode($message));
			}else{
				$hashed_password = password_hash($password, PASSWORD_DEFAULT);
				$stmt = $conn->prepare("UPDATE users SET password = ? WHERE credential_id = ?");
				$stmt->bind_param("si", $hashed_password, $serial_id);
				$stmt->execute();
				$stmt->close();
				$message["error"] = false;
				$message["error_message"] = "Success";
				die(json_encode($message));	
			}
		}
	}die(json_encode($message));
?>