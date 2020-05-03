<?php

require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";	
	if(isset($_POST["registration_number"]) && isset($_POST["type"]) && isset($_POST["credential_id"]) && isset($_POST["pet_name"]) && isset($_POST["simulator_device_id"])){
		$registration_number = (int)$_POST["registration_number"];
		$credential_id = (int)$_POST["credential_id"];
		$type = mysqli_real_escape_string($conn, $_POST["type"]);
		$pet_name = mysqli_real_escape_string($conn, $_POST["pet_name"]);
		$simulator_device_id = mysqli_real_escape_string($conn, $_POST["simulator_device_id"]);

		if(empty($registration_number) || empty($type) || empty($credential_id) || empty($pet_name) || empty($simulator_device_id)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters";	
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT registration_number, type, verified FROM boats WHERE registration_number = ? and type = ? ");
			$stmt->bind_param("is", $registration_number, $type);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) == 1){
				$row = mysqli_fetch_assoc($result);
				$verified = (int)$row["verified"];
				if($verified == -1){
					$stmt = $conn->prepare("UPDATE boats SET pet_name = ?, credential_id  = ?,  simulator_device_id = ?, verified = 0 WHERE registration_number = ?");
					$stmt->bind_param("sisi", $pet_name, $credential_id, $simulator_device_id, $registration_number);
					$stmt->execute();
					$stmt->close();
					$message["error"] = false;
					$message["error_message"] = "Success";	
					die(json_encode($message));
				}else{
					$message["error"] = true;
					$message["error_message"] = "Boat is already added";	
					die(json_encode($message));
				}
			}else{
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";	
				die(json_encode($message));
			}
		}
		
	}die(json_encode($message))

?>