<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["problem_id"])){
		$problem_id = (int) $_POST["problem_id"];
		if(empty($problem_id)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters";
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT problem_id, solution_header, solution_description FROM  problem_solutions WHERE problem_id = ? ORDER BY problem_id DESC LIMIT 10");
			$stmt->bind_param("i", $problem_id);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) > 0){
				$data = [];
				while ($row = mysqli_fetch_assoc($result)){
				$responce = [];
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
				$message["error_message"] = "No user found";	
				die(json_encode($message));
			}
		}
	}die(json_encode($message));
?>