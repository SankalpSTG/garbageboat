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
			$stmt = $conn->prepare("SELECT serial_id, project_name, project_description, location_lat, location_lng, is_anonymous FROM projects WHERE serial_id = ? limit 10");
			$stmt->bind_param("i", $serial_id);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) > 0){
				$row = mysqli_fetch_assoc($result);
				$data["project_id"] = (string)$row["serial_id"];
				$data["project_name"] = (string)$row["project_name"];
				$data["project_description"] = (int)$row["project_description"];
				$data["location_lat"] = (string)$row["location_lat"];
				$data["location_lng"] = (string)$row["location_lng"];
				$data["is_anonymous"] = (int)$row["is_anonymous"];
				
				$message["error"] = false;
				$message["error_message"] = "Success";	
				$message["data"] = $data;
				die(json_encode($message));
			}else{
				$message["error"] = true;
				$message["error_message"] = "Project not found";	
				die(json_encode($message));	
			}
		}
	}die(json_encode($message));
?>