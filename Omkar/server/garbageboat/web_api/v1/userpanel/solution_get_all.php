<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	$stmt = $conn->prepare("SELECT serial_id, problem_id, solution_header, solution_description FROM problem_solutions ORDER BY serial_id DESC LIMIT 10");
	$stmt->execute();
	$result = $stmt->get_result();
	$stmt->close();
	if(mysqli_num_rows($result) > 0){
		$data = [];
		while ($row = mysqli_fetch_assoc($result)){
		$responce = [];
		$responce["serial_id"] = (int)$row["serial_id"];
		$responce["problem_id"] = (int)$row["problem_id"];
		$responce["solution_header"] = (string)$row["solution_header"];
		$responce["solution_description"] = (string)$row["solution_description"];
		array_push($data, $responce);
		}
		$message["data"] = $data;
		$message["error"] = false;
		$message["error_message"] = "Success";	
		die(json_encode($message));
	}else{
		$message["error"] = true;
		$message["error_message"] = "Solution not uploaded";	
		die(json_encode($message));
	}die(json_encode($message));
?>