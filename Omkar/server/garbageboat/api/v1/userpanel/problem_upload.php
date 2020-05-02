<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"]) && isset($_POST["category"]) && isset($_POST["problem"]) && isset($_POST["description"])){
		$serial_id = (int) $_POST["serial_id"];
		$category = mysqli_real_escape_string($conn, $_POST["category"]);
		$problem = mysqli_real_escape_string($conn, $_POST["problem"]);
		$description = mysqli_real_escape_string($conn, $_POST["description"]);
		if(empty($serial_id) || empty($problem) || empty($description) || empty($category)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters";
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("INSERT INTO problems_submitted (credential_id, category, problem, description) VALUES (?, ?, ?, ?)");
			$stmt->bind_param("isss", $serial_id, $category, $problem, $description);
			$stmt->execute();
			$stmt->close();
			$message["error"] = false;
			$message["error_message"] = "Success";
			die(json_encode($message));
		}
	}die(json_encode($message));
?>