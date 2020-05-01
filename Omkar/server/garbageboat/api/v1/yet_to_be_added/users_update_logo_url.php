<?php
require("../database/dbh.inc.php");
require("../files/upload_image.inc.php");
	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"]) && fileUploaded("logo")){
		$serial_id = (int) $_POST["serial_id"];
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
				$file= $_FILES["logo"];
				$fileextension = pathinfo(basename($file["name"]), PATHINFO_EXTENSION);
				$result = mysqli_query($conn, "SELECT running_number FROM  running_numbers WHERE keyname = 'profile_images'");
				$row = mysqli_fetch_assoc($result);
				$running_number = (int)$row["running_number"];
				$upload_status = uploadFile($file, $running_number, "profilepic/");
				if($upload_status == 1){
					$logo_url = "profilepic/" . ($running_number + 1) . "." .$fileextension;
					$stmt = $conn->prepare("UPDATE users SET logo_url = ? WHERE credential_id = ?");
					$stmt->bind_param("si", $logo_url, $serial_id);
					$stmt->execute();
					$stmt->close();
					$running_number = $running_number+1;
					$stmt = $conn->prepare("UPDATE running_numbers SET running_number = ? WHERE keyname = 'profile_images'");
					$stmt->bind_param("i", $running_number);
					$stmt->execute();
					$stmt->close();
					$message["error"] = false;
					$message["error_message"] = "Success";
					die(json_encode($message));	
				}
				
			}
		}
	}die(json_encode($message));
?>