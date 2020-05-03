<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["registration_number"]) ){
		$registration_number = (int)$_POST["registration_number"];
		if(empty($registration_number)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters1";	
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT pet_name, registration_number, type, credential_id, simulator_device_id, verified FROM boats WHERE registration_number = ? limit 10");
			$stmt->bind_param("i", $registration_number);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) > 0){
				$data = [];
				while ($row = mysqli_fetch_assoc($result)){
				$responce = [];
				$responce["pet_name"] = (string)$row["pet_name"];
				$responce["registration_number"] = (string)$row["registration_number"];
				$responce["type"] = (string)$row["type"];
				$responce["credential_id"] = (int)$row["credential_id"];
				$responce["simulator_device_id"] = (string)$row["simulator_device_id"];
				$responce["verified"] = (int)$row["verified"];
				array_push($data, $responce);
				}
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