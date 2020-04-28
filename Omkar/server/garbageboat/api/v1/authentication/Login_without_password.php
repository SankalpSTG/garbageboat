<?php
require ("../database/dbh.inc.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";	
	
	if(isset($_POST["email_id"])){
		$email_id = mysqli_real_escape_string($conn, $_POST["email_id"]);
		if(empty($email_id)){
			$message["error"] = true;
			$message["error_message"] = "Invalid e-mail";
			die(json_encode($message));	
		}else{
			if((filter_var($email_id, FILTER_VALIDATE_EMAIL) === false)){
				$message["error"] = true;
				$message["error_message"] = "Invalid e-mail";
				die(json_encode($message));
			}else{
				$stmt = $conn->prepare("SELECT serial_id FROM credentials WHERE email_id = ?");
				$stmt->bind_param("s", $email_id);
				$stmt->execute();
				$result = $stmt->get_result();
				$stmt->close();
				if(mysqli_num_rows($result) > 0){	
					$row = mysqli_fetch_assoc($result);
					$message["error"] = false;
					$message["error_message"] = "Success";
					$data["email_id"] = $email_id;
					$data["serial_id"] = (int) $row["serial_id"];
					$message["data"]= $data;
					die(json_encode($message));
				}else{
					$message["error"] = true;
					$message["error_message"] = "User doesn't exist";
					die(json_encode($message));	
				}
			}			
		}
	}
	die(json_encode($message));
?>