<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"]) && isset($_POST["location_lat"]) && isset($_POST["location_lng"])){
		$serial_id = (int) $_POST["serial_id"];
		$location_lat = mysqli_real_escape_string($conn, $_POST["location_lat"]);
		$location_lng = mysqli_real_escape_string($conn, $_POST["location_lng"]);
		if(empty($serial_id) || empty($location_lat) || empty($location_lng)){
			$message["error"] = true;
			$message["error_message"] = "Invalid parameters";
			die(json_encode($message));	
		}else{
			if(!is_numeric($serial_id)|| !is_string($location_lat)|| !is_string($location_lng)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";
			die(json_encode($message));
			}else{
				$stmt = $conn->prepare("UPDATE users SET location_lat = ?, location_lng = ? WHERE credential_id = ?");
				$stmt->bind_param("ssi", $location_lat,$location_lng, $serial_id);
				$stmt->execute();
				$stmt->close();
				$message["error"] = false;
				$message["error_message"] = "Success";
				die(json_encode($message));	
			}
		}
	}die(json_encode($message));
?>