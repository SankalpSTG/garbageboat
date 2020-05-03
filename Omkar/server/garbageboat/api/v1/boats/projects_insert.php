<?php

require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";	
	if(isset($_POST["credential_id"]) && isset($_POST["project_name"]) && isset($_POST["project_description"]) && isset($_POST["location_lat"]) && isset($_POST["location_lng"]) && isset($_POST["is_anonymous"])){
		$credential_id = (int)$_POST["credential_id"];
		$project_name = mysqli_real_escape_string($conn, $_POST["project_name"]);
		$project_description = mysqli_real_escape_string($conn, $_POST["project_description"]);
		$location_lat = mysqli_real_escape_string($conn, $_POST["location_lat"]);
		$location_lng = mysqli_real_escape_string($conn, $_POST["location_lng"]);
		$is_anonymous = mysqli_real_escape_string($conn, $_POST["is_anonymous"]);

		if(empty($credential_id) || empty($project_name)  || empty($project_description) || empty($location_lat) || empty($location_lng) || !is_numeric($is_anonymous)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters ";	
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("INSERT INTO projects (credential_id, project_name, project_description, location_lat, location_lng, is_anonymous) VALUES (?, ?, ?, ?, ?, ?)");
			$stmt->bind_param("isssss", $credential_id, $project_name, $project_description, $location_lat, $location_lng, $is_anonymous);
			$stmt->execute();
			$stmt->close();
			$message["error"] = false;
			$message["error_message"] = "Success";	
			die(json_encode($message));
			
		}
		
	}die(json_encode($message))

?>