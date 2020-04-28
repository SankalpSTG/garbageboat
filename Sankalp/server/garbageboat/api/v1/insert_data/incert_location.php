<?php
require ("../database/dbh.inc.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";	
	
	if(isset($_POST["stringdata"]) && isset($_POST["intdata"]) && isset($_POST["floatdata"])){
		$stringdata=mysqli_real_escape_string($conn, $_POST["stringdata"]);
		$intdata=(int)$_POST["intdata"];
		$floatdata=(float)$_POST["floatdata"];
		
		if(empty($stringdata) || empty($intdata) || empty($floatdata)){
			$message["error"] = true;
			$message["error_message"] = "Required all parameters";
			die(json_encode($message));	
		}else{
			if(!is_int($intdata) ||(filter_var($floatdata, FILTER_VALIDATE_FLOAT) === false)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters  ".$stringdata."   ".$intdata."   ".$floatdata;
				die(json_encode($message));
			}else{
				$stmt = $conn->prepare("INSERT INTO testtable (stringdata, intdata, floatdata) VALUES (?, ?, ?)");
				$stmt->bind_param("sid", $stringdata, $intdata, $floatdata);
				if($stmt->execute()){
					$stmt->close();
					$message["error"] = false;
					$message["error_message"] = "Success";
					die(json_encode($message));
				}else{
					$message["error"] = true;
					$message["error_message"] = "Failed to update location";
					die(json_encode($message));
				}
			}
		}
	}
	die(json_encode($message));
?>