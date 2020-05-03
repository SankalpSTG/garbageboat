<?php

require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";	
	if(isset($_POST["project_id"]) && isset($_POST["boat_id"])){
		$project_id = (int)$_POST["project_id"];
		$boat_id = (int)($_POST["boat_id"]);

		if(empty($project_id) || empty($boat_id)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters";	
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("INSERT INTO project_boat_mapping (project_id, boat_id) VALUES (?, ?)");
			$stmt->bind_param("ii", $project_id, $boat_id);
			$stmt->execute();
			$stmt->close();
			$message["error"] = false;
			$message["error_message"] = "Success";	
			die(json_encode($message));
		}
		
	}die(json_encode($message));

?>