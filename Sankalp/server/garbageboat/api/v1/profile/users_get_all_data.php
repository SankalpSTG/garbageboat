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
				$stmt = $conn->prepare("SELECT cre.email_id, cre.mobile_no, cre.verification_level, usr.company_name, usr.logo_url, usr.pincode, usr.address, usr.location_lat, usr.location_lng, count(prj.serial_id) as no_of_projects FROM credentials as cre, users as usr, projects as prj WHERE cre.serial_id = usr.credential_id AND cre.serial_id = prj.credential_id AND cre.serial_id = ?");
				$stmt->bind_param("i", $serial_id);
				$stmt->execute();
				$result = $stmt->get_result();
				$row = mysqli_fetch_assoc($result);
				$stmt->close();
				if(mysqli_num_rows($result)>0){
					$base_image_path = "garbageboat/data/images/";
					$data["email_id"] = (string) $row["email_id"];
					$data["mobile_no"] =  (int)$row["mobile_no"];
					$data["verification_level"] = (int) $row["verification_level"];
					$data["company_name"] = (string) $row["company_name"];
					$data["logo_url"] = (string)($serveradd.$base_image_path.$row["logo_url"]);
					$data["pincode"] = (int) $row["pincode"];
					$data["address"] = (string) $row["address"];
					$data["location_lat"] = (string) $row["location_lat"];
					$data["location_lng"] = (string) $row["location_lng"];
					$data["no_of_projects"] = (int) $row["no_of_projects"];
					$message["error"] = false;
					$message["error_message"] = "Success";
					$message["data"] = $data;
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