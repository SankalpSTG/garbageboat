<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"]) && isset($_POST["category"]) && isset($_POST["header"]) && isset($_POST["description"]) && isset($_POST["rating"])){
		$serial_id = (int) $_POST["serial_id"];
		$category = mysqli_real_escape_string($conn, $_POST["category"]);
		$header = mysqli_real_escape_string($conn, $_POST["header"]);
		$description = mysqli_real_escape_string($conn, $_POST["description"]);
		$rating = (int) $_POST["rating"];
		if(empty($serial_id) || empty($header) || empty($description) || empty($category) || empty($rating)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters";
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("INSERT INTO user_feedback (credential_id, category, header, description, rating) VALUES (?, ?, ?, ?, ?)");
			$stmt->bind_param("isssi", $serial_id, $category, $header, $description, $rating);
			$stmt->execute();
			$stmt->close();
			$message["error"] = false;
			$message["error_message"] = "Success";
			die(json_encode($message));
		}
	}die(json_encode($message));
?>