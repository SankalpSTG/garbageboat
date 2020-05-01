<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"])){
		$serial_id = mysqli_real_escape_string($conn, $_POST["serial_id"]);
		if(empty($serial_id)){
			$message["error"] = true;
			$message["error_message"] = "Required all parameters";
			die(json_encode($message));
		}else{
			if(!is_numeric($serial_id)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";
				die(json_encode($message));
			}else{
				$stmt = $conn->prepare("SELECT company_name, logo_url, pincode, address, location_lat, location_lng FROM users WHERE credential_id = ?");
				$stmt->bind_param("i", $serial_id);
				$stmt->execute();
				$result = $stmt->get_result();
				$row = mysqli_fetch_assoc($result);
				$stmt->close();
				if(mysqli_num_rows($result)==1){
					$message["company_name"] = (string) $row["company_name"];
					$message["logo_url"] = (string) $row["logo_url"];
					$message["pincode"] = (int) $row["pincode"];
					$message["address"] = (string) $row["address"];
					$message["location_lat"] = (string) $row["location_lat"];
					$message["location_lng"] = (string) $row["location_lng"];
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