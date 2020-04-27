<?php
	require("../database/dbh.inc.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";
	if(isset($_POST["time"])){
		$sendtime = $_POST["time"];
		if(empty($sendtime)){
			$message["error"] = true;
			$message["error_message"] = "Required all parameters";
			die(json_encode($message));
		}else{
			if(!is_numeric($sendtime)){
				$message["error"] = true;
				$message["error_message"] = "Invalid Parameters";
				die(json_encode($message));
			}else{
				$stmt = $conn->prepare("UPDATE latencytest set sendtime = ? WHERE testid = 1");
				$stmt->bind_param("i", $sendtime);
				if($stmt->execute()){
					$stmt->close();
					$message["error"] = false;
					$message["error_message"] = "Success";
					die(json_encode($message));
				}else{
					$message["error"] = true;
					$message["error_message"] = "Failed to update time";
					die(json_encode($message));
				}
			}
		}
	}
	die(json_encode($message));
?>