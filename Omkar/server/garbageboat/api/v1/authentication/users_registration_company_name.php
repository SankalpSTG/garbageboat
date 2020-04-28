<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["company_name"])){
		$company_name = mysqli_real_escape_string($conn, $_POST["company_name"]);
		if(empty($company_name)){
			$message["error"] = true;
			$message["error_message"] = "Invalid parameters";
			die(json_encode($message));	
		}else{
			if(!is_string($company_name)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";
			die(json_encode($message));
			}else{
				$stmt = $conn->prepare("INSERT INTO users (company_name) VALUES (?) ");
				$stmt->bind_param("s", $company_name);
				$stmt->execute();
				$stmt->close();
				$message["error"] = false;
				$message["error_message"] = "Success";
				die(json_encode($message));	
			}
		}
	}die(json_encode($message));
?>