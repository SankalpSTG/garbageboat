<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"]) ){
		$serial_id = (int)$_POST["serial_id"];
		if(empty($serial_id)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters";	
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT project_name, project_description, location_lat, location_lng, is_anonymous FROM projects WHERE serial_id = ? limit 10");
			$stmt->bind_param("i", $serial_id);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) > 0){
				$row = mysqli_fetch_assoc($result);
				$message["project_name"] = (string)$row["project_name"];
				$message["project_description"] = (int)$row["project_description"];
				$message["location_lat"] = (string)$row["location_lat"];
				$message["location_lng"] = (int)$row["location_lng"];
				$message["is_anonymous"] = (int)$row["is_anonymous"];
				$message["error"] = false;
				$message["error_message"] = "Success";	
				die(json_encode($message));
			}else{
				$message["error"] = true;
				$message["error_message"] = "Project not found";	
				die(json_encode($message));	
			}
		}
	}die(json_encode($message));
?>