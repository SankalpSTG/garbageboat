<?php
require("../database/dbh.inc.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";
	if(isset($_POST["email_id"]) && isset($_POST["mobile_no"])){
		$emailid = mysqli_real_escape_string($conn, $_POST["email_id"]);
		$mobileno = mysqli_real_escape_string($conn, $_POST["mobile_no"]);
		
		if(empty($emailid) && empty($mobileno)){
			$message["error"] = true;
			$message["error_message"] = "Required all parameters";
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT serial_id FROM credentials WHERE email_id = ?");
			$stmt->bind_param("s", $emailid);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) != 0){
				$row = mysqli_fetch_assoc($result);
				$message["error"] = false;
				$message["error_message"] = "User already exists";
				$message["data"] = $row["serial_id"];
				die(json_encode($message));
			}else{
				$stmt = $conn->prepare("INSERT INTO credentials(email_id, mobile_no)VALUES(?, ?)");
				$stmt->bind_param("si", $emailid, $mobileno);
				$stmt->execute();
				$stmt->close();
				$stmt = $conn->prepare("SELECT serial_id FROM credentials WHERE email_id = ?");
				$stmt->bind_param("s", $emailid);
				$stmt->execute();
				$result = $stmt->get_result();
				$stmt->close();				
				if(mysqli_num_rows($result) > 0){
					$row = mysqli_fetch_assoc($result);
					$message["error"] = false;
					$message["error_message"] = "Success";
					$message["data"] = (int)$row["serial_id"];
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