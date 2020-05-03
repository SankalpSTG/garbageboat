<?php

require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";	
	if(isset($_POST["registration_number"]) && isset($_POST["type"])){
		$registration_number = (int)$_POST["registration_number"];
		$type = mysqli_real_escape_string($conn, $_POST["type"]);

		if(empty($registration_number) || empty($type)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters";	
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT registration_number FROM boats WHERE registration_number = ?");
			$stmt->bind_param("i", $registration_number);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) == 0){
				$stmt = $conn->prepare("INSERT INTO boats (registration_number, type, verified) VALUES (?, ?, -1)");
				$stmt->bind_param("is", $registration_number, $type);
				$stmt->execute();
				$stmt->close();
				$message["error"] = false;
				$message["error_message"] = "Success";	
				die(json_encode($message));
			}else{
				$message["error"] = true;
				$message["error_message"] = "Boat already added";	
				die(json_encode($message));
			}
		}
		
	}die(json_encode($message))

?>