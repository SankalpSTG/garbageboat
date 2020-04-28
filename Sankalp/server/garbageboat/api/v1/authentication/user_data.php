<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"])){
		$serial_id = mysqli_real_escape_string($conn, $_POST["serial_id"]);
		if(empty($serial_id)){
			$message["error"] = true;
			$message["error_message"] = "Invalid parameters";
			die(json_encode($message));
		}else{
			if(!is_numeric($serial_id)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";
				die(json_encode($message));
			}else{
				$stmt = $conn->prepare("SELECT cre.email_id, cre.mobile_no, cre.verification_level, usr.company_name, usr.logo_url, usr.pincode, usr.address, usr.location_lat, usr.location_lng FROM credentials as cre, users as usr WHERE cre.serial_id = usr.credential_id = ?");
				$stmt->bind_param("i", $serial_id);
				$stmt->execute();
				$result = $stmt->get_result();
				$row = mysqli_fetch_assoc($result);
				$stmt->close();
				if(mysqli_num_rows($result)>1){
					$message["email_id"] = $row["email_id"];
					$message["mobile_no"] = $row["mobile_no"];
					$message["verification_level"] = $row["verification_level"];
					$message["company_name"] = $row["company_name"];
					$message["logo_url"] = $row["logo_url"];
					$message["pincode"] = $row["pincode"];
					$message["address"] = $row["address"];
					$message["location_lat"] = $row["location_lat"];
					$message["location_lng"] = $row["location_lng"];
					$message["error"] = false;
					$message["error_message"] = "Success";
					die(json_encode($message));
				}else{
					$message["error"] = true;
					$message["error_message"] = "Invalid user";
					die(json_encode($message));
				}
			}
		}
	}
	die(json_encode($message));


?>