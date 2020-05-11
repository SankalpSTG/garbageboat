<?php

require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";	
	if(isset($_POST["project_id"]) && isset($_POST["serial_id"])){
		$project_id = (int)$_POST["project_id"];
		$boat_id = (int)($_POST["serial_id"]);

		if(empty($project_id) || empty($boat_id)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters";	
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("DELETE FROM project_boat_mapping WHERE project_id = ? AND boat_id = ?");
			$stmt->bind_param("ii", $project_id, $boat_id);
			$stmt->execute();
			$stmt->close();
			$message["error"] = false;
			$message["error_message"] = "Success";	
			die(json_encode($message));
		}
		
	}die(json_encode($message));

?>