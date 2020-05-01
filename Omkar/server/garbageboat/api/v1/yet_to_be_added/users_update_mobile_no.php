<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"]) && isset($_POST["mobile_no"])){
		$serial_id = (int) $_POST["serial_id"];
		$mobile_no = (int) $_POST["mobile_no"];
		if(empty($serial_id) || empty($mobile_no)){
			$message["error"] = true;
			$message["error_message"] = "Invalid parameters";
			die(json_encode($message));	
		}else{
			if(!is_numeric($serial_id) || !preg_match('/^[0-9]{10}+$/', $mobile_no) ){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";
			die(json_encode($message));
			}else{
				$stmt = $conn->prepare("UPDATE credentials SET mobile_no = ? WHERE serial_id = ?");
				$stmt->bind_param("ii", $mobile_no, $serial_id);
				$stmt->execute();
				$stmt->close();
				$message["error"] = false;
				$message["error_message"] = "Success";
				die(json_encode($message));	
			}
		}
	}die(json_encode($message));
?>