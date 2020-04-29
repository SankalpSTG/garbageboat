<?php
require("../database/dbh.inc.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";
	if(isset($_POST["email_id"]) && isset($_POST["password"])){
		$email_id = mysqli_real_escape_string($conn, $_POST["email_id"]);
		$user_password = mysqli_real_escape_string($conn, $_POST["password"]);
		if(empty($email_id) && empty($password)){
			$message["error"] = true;
			$message["error_message"] = "Required all parameters";
			die(json_encode($message));
		}else{
		if(filter_var($email_id, FILTER_VALIDATE_EMAIL) === false){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";	
				die(json_encode($message));
			}else{
				$stmt = $conn->prepare("SELECT cred.serial_id, usr.password FROM users as usr, credentials as cred WHERE usr.credential_id = cred.serial_id and email_id = ?");
				$stmt->bind_param("s", $email_id);
				$stmt->execute();
				$result = $stmt->get_result();
				$stmt->close();
				if(mysqli_num_rows($result) == 1){
					$row = mysqli_fetch_assoc($result);
					$serial_id = (int) $row["serial_id"];
					$password = (string) $row["password"];
					if(password_verify($user_password, $password)==true){
						$message["data"] = $serial_id;
						$message["error"] = false;
						$message["error_message"] = "Success";
						die(json_encode($message));
					}else{
					$message["error"] = true;
					$message["error_message"] = "Invalid password";
					die(json_encode($message));
					}
				}else{
					$message["error"] = true;
					$message["error_message"] = "Invalid user";
					die(json_encode($message));
				}
			}	
		}
		
	}
	die(json_encode($message));
?>