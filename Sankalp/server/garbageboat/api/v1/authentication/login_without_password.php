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
				$stmt = $conn->prepare("SELECT serial_id, verification_level, account_level FROM credentials WHERE email_id = ?");
				$stmt->bind_param("s", $email_id);
				$stmt->execute();
				$result = $stmt->get_result();
				$stmt->close();
				if(mysqli_num_rows($result) == 1){	
					$row = mysqli_fetch_assoc($result);
					if($row["verification_level"] == 0 && $row["account_level"] == 0){
						$data["serial_id"] = $row["serial_id"];
						$data["account_level"] = (int)$row["account_level"];
						$data["verification_level"] = (int)$row["verification_level"];
						$message["error"] = false;
						$message["error_message"] = "Success";
						$message["data"] = $data;
						die(json_encode($message));
					}else{
						$message["error"] = true;
						$message["error_message"] = "Please Login Through Profile Tab";
						die(json_encode($message));
					}
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