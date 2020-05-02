<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["problem_id"]) && isset($_POST["solution_header"]) && isset($_POST["solution_description"])){
		$problem_id = (int) $_POST["problem_id"];
		$solution_header = mysqli_real_escape_string($conn, $_POST["solution_header"]);
		$solution_description = mysqli_real_escape_string($conn, $_POST["solution_description"]);
		if(empty($problem_id) || empty($solution_description) || empty($solution_header)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters";
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("INSERT INTO problem_solutions(problem_id, solution_header, solution_description) VALUES (?, ?, ?)");
			$stmt->bind_param("iss", $problem_id, $solution_header, $solution_description);
			$stmt->execute();
			$stmt->close();
			$message["error"] = false;
			$message["error_message"] = "Success";
			die(json_encode($message));
		}
	}die(json_encode($message));
?>