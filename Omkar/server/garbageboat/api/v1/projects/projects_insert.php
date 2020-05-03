<?php

require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";	
	if(isset($_POST["serial_id"]) && isset($_POST["project_name"]) && isset($_POST["project_description"]) && isset($_POST["is_anonymous"])){
		$serial_id = (int)$_POST["serial_id"];
		$project_name = mysqli_real_escape_string($conn, $_POST["project_name"]);
		$project_description = mysqli_real_escape_string($conn, $_POST["project_description"]);
		$is_anonymous = (int)($_POST["is_anonymous"]);

		if(empty($serial_id) || empty($project_name)  || empty($project_description) || !is_numeric($is_anonymous)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters ";	
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT project_name FROM projects WHERE credential_id = ?");
			$stmt->bind_param("i", $serial_id);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			$row = mysqli_fetch_assoc($result);
			if((string)$row["project_name"] != $project_name){
				$stmt = $conn->prepare("INSERT INTO projects (credential_id, project_name, project_description, is_anonymous) VALUES (?, ?, ?, ?)");
				$stmt->bind_param("issi", $serial_id, $project_name, $project_description, $is_anonymous);
				$stmt->execute();
				$stmt->close();
				$stmt = $conn->prepare("SELECT serial_id FROM projects WHERE credential_id = ? and project_name = ?");
				$stmt->bind_param("is", $serial_id, $project_name);
				$stmt->execute();
				$result = $stmt->get_result();
				$stmt->close();
				$row = mysqli_fetch_assoc($result);
				$message["project_id"] = (string)$row["serial_id"] ;
				$message["error"] = false;
				$message["error_message"] = "Success";	
				die(json_encode($message));
			}else{
				$message["error"] = true;
				$message["error_message"] = "Project name is already exist";	
				die(json_encode($message));
			}
			
			
		}
		
	}die(json_encode($message));

?>