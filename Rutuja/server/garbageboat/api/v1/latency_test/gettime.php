<?php
	require("../database/dbh.inc.php");
	
	$stmt = $conn->prepare("SELECT sendtime FROM latencytest WHERE testid = 1");
	$stmt->execute();
	$result = $stmt->get_result();
	$stmt->close();
	
	if(mysqli_num_rows($result) == 0){		
		$message["error"] = true;
		$message["error_message"] = "Invalid Test Id";
		die(json_encode($message));
	}
	$row = mysqli_fetch_assoc($result);
	$message["error"] = false;
	$message["error_message"] = "Success";
	$message["data"] = $row["sendtime"];
	
	die(json_encode($message));
?>