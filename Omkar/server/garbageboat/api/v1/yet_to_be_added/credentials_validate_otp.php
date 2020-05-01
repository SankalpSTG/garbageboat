<?php
require ("../database/dbh.inc.php");
require ("../other/encdec.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";
	if(isset($_POST["serial_id"]) && isset($_POST["user_otp"])){
		$serial_id = (int) $_POST["serial_id"];
		$user_otp = (int) $_POST["user_otp"];
		if(empty($serial_id) && empty($user_otp)){
			$message["error"] = true;
			$message["error_message"] = "Required all parameters";
			die(json_encode($message));
		}else{
			if(!is_numeric($serial_id) && !is_numeric($otp)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";	
				die(json_encode($message));
			}else{
				$stmt = $conn->prepare("SELECT token, token_key, token_iv FROM credentials WHERE serial_id = ?");
				$stmt->bind_param("s", $serial_id);
				$stmt->execute();
				$result = $stmt->get_result();
				$stmt->close();
				if(mysqli_num_rows($result) > 0){	
					$row = mysqli_fetch_assoc($result);
					$otp = encrypt_decrypt(1, $row["token"], $row["token_key"], $row["token_iv"]);
					if($otp == $user_otp){
						$stmt = $conn->prepare("UPDATE credentials SET token = NULL, token_key = NULL, token_iv = NULL WHERE serial_id = ?");
						$stmt->bind_param("i", $serial_id);
						$stmt->execute();
						$stmt->close();
						$message["error"] = false;
						$message["error_message"] = "Success";
						die(json_encode($message));	
					}else{
						$message["error"] = true;
						$message["error_message"] = "Failed to update";
						die(json_encode($message));	
					}
				}
			}			
		}
	}
	die(json_encode($message));
?>