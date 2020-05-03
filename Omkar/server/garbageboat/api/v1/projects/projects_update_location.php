<?php

require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";	
	if(isset($_POST["serial_id"]) && isset($_POST["location_lat"]) && isset($_POST["location_lng"])){
		$serial_id = (int)$_POST["serial_id"];
		$location_lat = mysqli_real_escape_string($conn, $_POST["location_lat"]);
		$location_lng = mysqli_real_escape_string($conn, $_POST["location_lng"]);

		if(empty($serial_id) || empty($location_lat) || empty($location_lng)){
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
				$stmt = mysqli_query($conn, "UPDATE projects SET location_lat = $location_lat, location_lng  = $location_lng WHERE serial_id = $serial_id");
				$message["error"] = false;
				$message["error_message"] = "Success";	
				die(json_encode($message));
			}else{
				$message["error"] = true;
				$message["error_message"] = "Project is not added";	
				die(json_encode($message));
			}
		}
		
	}die(json_encode($message));

?>