<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["search"])){
		$search = mysqli_real_escape_string($conn, $_POST["search"]);
		if(empty($search)){
			$message["error"] = true;
			$message["error_message"] = "Require all parameters";	
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("SELECT cred.serial_id, cred.email_id, cred.mobile_no, cred.verification_level, usr. company_name, usr.logo_url, usr.address, usr.pincode FROM credentials as cred, users as usr WHERE cred.account_level = 0 and usr.credential_id = cred.serial_id LIKE ? limit 10");
			$stmt->bind_param("s",$search);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) > 0){
				while ($row = mysqli_fetch_assoc($result)){
				$message["serial_id"] = (int)$row["serial_id"];
				$message["email_id"] = (string)$row["email_id"];
				$message["mobile_no"] = (int)$row["mobile_no"];
				$message["verification_level"] = (int)$row["verification_level"];
				$message["company_name"] = (string)$row["company_name"];
				$message["logo_url"] = (string)$row["logo_url"];
				$message["pincode"] = (int)$row["pincode"];
				$message["address"] = (string)$row["address"];
				$message["error"] = false;
				$message["error_message"] = "Success";	
				die(json_encode($message));
				}
				
			}else{
				$message["error"] = true;
				$message["error_message"] = "No user found";	
				die(json_encode($message));
			}
		}
	}die(json_encode($message));
?>