<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	$stmt = $conn->prepare("SELECT serial_id, credential_id, category, header, description, rating FROM user_feedback ORDER BY serial_id DESC LIMIT 10");
	$stmt->execute();
	$result = $stmt->get_result();
	$stmt->close();
	if(mysqli_num_rows($result) > 0){
		$data = [];
		while ($row = mysqli_fetch_assoc($result)){
		$responce = [];
		$responce["serial_id"] = (int)$row["serial_id"];
		$responce["credential_id"] = (int)$row["credential_id"];
		$responce["category"] = (string)$row["category"];
		$responce["header"] = (string)$row["header"];
		$responce["description"] = (string)$row["description"];
		$responce["rating"] = (string)$row["rating"];
		array_push($data, $responce);
		}
		$message["data"] = $data;
		$message["error"] = false;
		$message["error_message"] = "Success";	
		die(json_encode($message));
	}else{
		$message["error"] = true;
		$message["error_message"] = "No feedback given";	
		die(json_encode($message));
	}die(json_encode($message));
?>