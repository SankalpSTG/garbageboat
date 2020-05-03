<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["registration_number"]) ){
		$registration_number = $_POST["registration_number"];
		if(empty($registration_number)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters1";	
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT pet_name, registration_number, type, credential_id, simulator_device_id, verified FROM boats WHERE registration_number = ?");
			$stmt->bind_param("i", $registration_number);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) > 0){
				$row = mysqli_fetch_assoc($result);
				
				$data["pet_name"] = (string)$row["pet_name"];
				$data["registration_number"] = (string)$row["registration_number"];
				$data["type"] = (string)$row["type"];
				$data["credential_id"] = (int)$row["credential_id"];
				$data["simulator_device_id"] = (string)$row["simulator_device_id"];
				$data["verified"] = (int)$row["verified"];
				
				$message["data"] = $data;
				$message["error"] = false;
				$message["error_message"] = "Success";	
				die(json_encode($message));
			}else{
				$message["error"] = true;
				$message["error_message"] = "No boat is register with registration number ". $registration_number;	
				die(json_encode($message));	
			}
		}
	}die(json_encode($message));
?>