<?php

require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";	
	if(isset($_POST["registration_number"])){
		$registration_number = (int)$_POST["registration_number"];

		if(empty($registration_number)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters";	
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT registration_number, verified FROM boats WHERE registration_number = ?");
			$stmt->bind_param("i", $registration_number);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) == 1){
				$row = mysqli_fetch_assoc($result);
				$verified = (int)$row["verified"];
				if($verified == 0){
					$stmt = $conn->prepare("UPDATE boats SET pet_name = NULL, credential_id  = NULL, simulator_device_id = NULL, verified = -1 WHERE registration_number = ?");
					$stmt->bind_param("i", $registration_number);
					$stmt->execute();
					$stmt->close();
					$message["error"] = false;
					$message["error_message"] = "Success";	
					die(json_encode($message));
				}else{
					$message["error"] = true;
					$message["error_message"] = "Boat is not added";	
					die(json_encode($message));
				}
			}else{
				$message["error"] = true;
				$message["error_message"] = "No boat registered with registration number ". $registration_number;	
				die(json_encode($message));
			}
		}
		
	}die(json_encode($message));

?>