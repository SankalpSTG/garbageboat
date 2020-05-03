<?php

require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";	
	if(isset($_POST["serial_id"])){
		$serial_id = (int)$_POST["serial_id"];

		if(empty($serial_id)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters";	
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT serial_id FROM projects WHERE serial_id = ?");
			$stmt->bind_param("i", $serial_id);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) == 1){
					$stmt = $conn->prepare("UPDATE projects SET credential_id = NULL, project_name = NULL, project_description = NULL, location_lat = NULL, location_lng = NULL, is_anonymous = NULL WHERE serial_id = ?");
					$stmt->bind_param("i", $serial_id);
					$stmt->execute();
					$stmt->close();
					$stmt = $conn->prepare("DELETE FROM project_boat_mapping WHERE project_id = ?");
					$stmt->bind_param("i", $serial_id);
					$stmt->execute();
					$stmt->close();
					$message["error"] = false;
					$message["error_message"] = "Success";	
					die(json_encode($message));
				}else{
					$message["error"] = true;
					$message["error_message"] = "Project not registered";	
					die(json_encode($message));
			}
		}
		
	}die(json_encode($message));

?>