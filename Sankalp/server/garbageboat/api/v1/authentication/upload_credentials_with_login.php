<?php
require("../database/dbh.inc.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";
	if(isset($_POST["email_id"]) && isset($_POST["mobile_no"])){
		$email_id = mysqli_real_escape_string($conn, $_POST["email_id"]);
		$mobile_no = mysqli_real_escape_string($conn, $_POST["mobile_no"]);
		
		if(empty($email_id) && empty($mobile_no)){
			$message["error"] = true;
			$message["error_message"] = "Required all parameters";
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT serial_id, verification_level, account_level FROM credentials WHERE email_id = ?");
			$stmt->bind_param("s", $email_id);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) != 0){
				$row = mysqli_fetch_assoc($result);
				if($row["verification_level"] != 0){
					$message["error"] = true;
					$message["error_message"] = "Please Login Through Profile";
					die(json_encode($message));
				}else{
					$message["error"] = false;
					$message["error_message"] = "Success";
					$data["serial_id"] = $row["serial_id"];
					$data["verification_level"] = $row["verification_level"];
					$data["account_level"] = $row["account_level"];
					$message["data"] = $data;
					die(json_encode($message));
				}
			}else{
				$verification_level = 0;
				$stmt = $conn->prepare("INSERT INTO credentials(email_id, mobile_no, verification_level)VALUES(?, ?, ?)");
				$stmt->bind_param("sii", $email_id, $mobile_no, $verification_level);
				$stmt->execute();
				$stmt->close();
				$stmt = $conn->prepare("SELECT serial_id, verification_level, account_level FROM credentials WHERE email_id = ?");
				$stmt->bind_param("s", $email_id);
				$stmt->execute();
				$result = $stmt->get_result();
				$stmt->close();				
				if(mysqli_num_rows($result) > 0){
					$row = mysqli_fetch_assoc($result);
					$message["error"] = false;
					$message["error_message"] = "Success";
					$data["serial_id"] = $row["serial_id"];
					$data["verification_level"] = $row["verification_level"];
					$data["account_level"] = $row["account_level"];
					$message["data"] = $data;
					die(json_encode($message));
				}else{
					$message["error"] = true;
					$message["error_message"] = "Failed to upload data";
				}
			}
		}
	}
	die(json_encode($message));
?>