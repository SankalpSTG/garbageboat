<?php
require("../database/dbh.inc.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";
	if(isset($_POST["serial_id"])){
		$serial_id = mysqli_real_escape_string($conn, $_POST["serial_id"]);
		if(empty($serial_id)){
			$message["error"] = true;
			$message["error_message"] = "Required all parameters";
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT account_level FROM credentials WHERE serial_id = ?");
			$stmt->bind_param("i", $serial_id);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) == 1){
				$row = mysqli_fetch_assoc($result);
				$account_level = (int)$row["account_level"];
				if($account_level == 1){
					$account_level = $account_level - 1;
					$stmt = $conn->prepare("UPDATE credentials SET account_level = ? WHERE serial_id = ?");
					$stmt->bind_param("ii", $account_level, $serial_id);
					$stmt->execute();
					$stmt->close();
					$message["error"] = false;
					$message["error_message"] = "Success";
				}else{
					$message["error"] = true;
					$message["error_message"] = "User doesn't approved";
					die(json_encode($message));
				}
			}else{
				$message["error"] = true;
				$message["error_message"] = "Failes to update";
				die(json_encode($message));
			}
		}
	}
	die(json_encode($message));
?>