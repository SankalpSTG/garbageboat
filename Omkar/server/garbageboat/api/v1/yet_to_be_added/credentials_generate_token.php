<?php
require ("../database/dbh.inc.php");
require ("../other/encdec.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";	
	if(isset($_POST["serial_id"])){
		$serial_id = (int) $_POST["serial_id"];
		if(empty($serial_id)){
			$$message["error"] = true;
			$message["error_message"] = "Required all parameters";
			die(json_encode($message));
		}else{
			if(!is_numeric($serial_id)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";	
				die(json_encode($message));
			}else{
				$otp = generateOtp(5);
				$token_key = generateRandomString(10);
				$token_iv = generateRandomString(10);
				$token = encrypt_decrypt(0, $otp, $token_key, $token_iv);
				$stmt = $conn->prepare("UPDATE credentials SET token = ?, token_key = ?, token_iv = ? WHERE serial_id = ?");
				$stmt->bind_param("sssi", $token, $token_key, $token_iv, $serial_id);
				if($stmt->execute()){
					$stmt->close();
					$message["data"] = $otp;
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
	die(json_encode($message));
?>