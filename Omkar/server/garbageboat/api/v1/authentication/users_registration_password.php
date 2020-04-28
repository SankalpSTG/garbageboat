<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["password"])){
		$password = mysqli_real_escape_string($conn, $_POST["password"]);
		if(empty($password)){
			$message["error"] = true;
			$message["error_message"] = "Invalid parameters";
			die(json_encode($message));	
		}else{
			if(!preg_match('/^(?=.*\d)(?=.*[@#\-_$%^&+=ยง!\?])(?=.*[a-z])(?=.*[A-Z])[0-9A-Za-z@#\-_$%^&+=ยง!\?]{8,20}$/',$password)){
				$message["error"] = true;
				$message["error_message"] = "Invalid password";
			die(json_encode($message));
			}else{
				$hashed_password = password_hash($password, PASSWORD_DEFAULT);
				$stmt = $conn->prepare("INSERT INTO users (password) VALUES (?)");
				$stmt->bind_param("s", $hashed_password);
				$stmt->execute();
				$stmt->close();
				$message["error"] = false;
				$message["error_message"] = "Success";
				die(json_encode($message));	
			}
		}
	}die(json_encode($message));
?>