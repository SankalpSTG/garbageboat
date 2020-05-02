<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"])){
		$serial_id = (int) $_POST["serial_id"];
		if(empty($serial_id)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters";
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT serial_id, problem FROM problems_submitted WHERE credential_id = ? ORDER BY serial_id DESC LIMIT 10");
			$stmt->bind_param("i", $serial_id);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) > 0){
				$data = [];
				while ($row = mysqli_fetch_assoc($result)){
				$responce = [];
				$responce["serial_id"] = (string)$row["serial_id"];
				$responce["problem"] = (string)$row["problem"];
				array_push($data, $responce);
				}
				$message["data"] = $data;
				$message["error"] = false;
				$message["error_message"] = "Success";	
				die(json_encode($message));
			}else{
				$message["error"] = true;
				$message["error_message"] = "Problem not uploaded";	
				die(json_encode($message));
			}
		}
	}die(json_encode($message));
?>