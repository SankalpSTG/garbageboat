<?php
require("../api/v1/database/dbh.inc.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";
	if(isset($_POST["email_id"]) && isset($_POST["user_password"])){
		$email_id = mysqli_real_escape_string($conn, $_POST["email_id"]);
		$user_password = mysqli_real_escape_string($conn, $_POST["user_password"]);
		if(empty($email_id) && ($user_password)){
			$message["error"] = true;
			$message["error_message"] = "Required all parameters";
			die(json_encode($message));
		}else{
		if((filter_var($email_id, FILTER_VALIDATE_EMAIL) === false)){
			$message["error"] = true;
			$message["error_message"] = "Invalid email-id";	
			die(json_encode($message));
		}else if (strlen($user_password) <= '8'){
			$message["error"] = true;
			$message["error_message"] = "Contain at least 8 digits";	
			die(json_encode($message));
		}else if (!preg_match("#[0-9]+#",$user_password)){
			$message["error"] = true;
			$message["error_message"] = "Contain at least 1 number";	
			die(json_encode($message));
		}else if (!preg_match("#[A-Z]+#",$user_password)){
			$message["error"] = true;
			$message["error_message"] = "Contain at least 1 capital letter";	
			die(json_encode($message));
		}else if (!preg_match('/[\'^£$%&*()}{@#~?><>,|=_+¬-]/', $user_password)){
			$message["error"] = true;
			$message["error_message"] = "Contain at least 1 special character";	
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT password FROM admin_credentials WHERE email_address = ?");
			$stmt->bind_param("s", $email_id);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) == 1){
				$row = mysqli_fetch_assoc($result);
				$password = (string) $row["password"];
				if(password_verify($user_password, $password)==true){
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