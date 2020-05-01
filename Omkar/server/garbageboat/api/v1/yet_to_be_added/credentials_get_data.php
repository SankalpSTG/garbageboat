<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"])){
		$serial_id = (int) $_POST["serial_id"];
		if(empty($serial_id)){
			$message["error"] = true;
			$message["error_message"] = "Invalid parameters";
			die(json_encode($message));
		}else{
			if(!is_numeric($serial_id)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";
				die(json_encode($message));
			}else{
				$stmt = $conn->prepare("SELECT email_id, mobile_no, verification_level FROM credentials WHERE serial_id = ?");
				$stmt->bind_param("i", $serial_id);
				$stmt->execute();
				$result = $stmt->get_result();
				$row = mysqli_fetch_assoc($result);
				$stmt->close();
				if(mysqli_num_rows($result)==1){
					$message["email_id"] = (string) $row["email_id"];
					$message["mobile_no"] =  (int)$row["mobile_no"];
					$message["verification_level"] = (int) $row["verification_level"];
					$message["error"] = false;
					$message["error_message"] = "Success";
					die(json_encode($message));
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