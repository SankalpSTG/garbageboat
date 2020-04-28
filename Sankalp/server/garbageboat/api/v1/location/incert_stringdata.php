<?php
	require ("../database/dbh.inc.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";
	
	if(isset($_POST[""])){
		$sendstring = $_POST["stringdata"]; 
		if(empty($stringdata,)){
			$message["error"] = true;
			$message["error_message"] = "Required all parameters";
			die(json_encode($message));
		}else{
			if(!is_float($stringdata)){
				$message["error"] = true;
				$message["error_message"] = "Invalid Parameters";
				die(json_encode($message));
			}else{
				$stmt = $conn->prepare("INCERT INTO testtable (stringdata) VALUES = (?)");
				$stmt->bind_param("sif", $stringdata);
				if($stmt->execute()){
					$stmt->close();
					$message["error"] = false;
					$message["error_message"] = "Success";
					die(json_encode($message));
				}else{
					$message["error"] = true;
					$message["error_message"] = "Failed to update data";
					die(json_encode($message));
				}
			}
		}
	}
	die(json_encode($message));
?>
