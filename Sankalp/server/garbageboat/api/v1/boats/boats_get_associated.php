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
			$stmt = $conn->prepare("SELECT pet_name, type, serial_id FROM boats WHERE serial_id IN (SELECT boat_id FROM project_boat_mapping WHERE project_id = ?)");
			$stmt->bind_param("i", $serial_id);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) > 0){
				$data = [];
				while ($row = mysqli_fetch_assoc($result)){
					$responce = [];
					$responce["pet_name"] = (string)$row["pet_name"];
					$responce["type"] = (string)$row["type"];
					$responce["serial_id"] = (string)$row["serial_id"];
					array_push($data, $responce);
				}
				$message["data"] = $data;
				$message["error"] = false;
				$message["error_message"] = "Success";	
				die(json_encode($message));
			}else{
				$message["error"] = true;
				$message["error_message"] = "No boats are Found";	
				die(json_encode($message));	
			}
		}
	}die(json_encode($message));
?>