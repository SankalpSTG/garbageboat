<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"]) && isset($_FILES["logo"])){
		$serialid = (int)$_POST["serial_id"];
		$file = $_FILES["logo"];
		if(empty($serialid)){
			$message["error"] = true;
			$message["error_message"] = "Invalid parameters";
			die(json_encode($message));	
		}else{
			if(!is_numeric($serialid)){
				$message["error"] = true;
				$message["error_message"] = "Invalid parameters";
				die(json_encode($message));
			}else{
				$fileextension = pathinfo(basename($file["name"]), PATHINFO_EXTENSION);
				$result = mysqli_query($conn, "SELECT running_number FROM  running_numbers WHERE keyname = 'profile_images'");
				$row = mysqli_fetch_assoc($result);
				$running_number = (int)$row["running_number"];
				$target_dir = $_SERVER["DOCUMENT_ROOT"]."/garbageboat/data/images/profilepic/";
				$target_file = $target_dir.basename($file["name"]);
				$check = json_encode(getImageSize($file["tmp_name"]));
				$imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));
				$target_file = $target_dir.($running_number+1).".".$imageFileType;
				if (move_uploaded_file($file["tmp_name"], $target_file)) {		
					$logo_url = "profilepic/" . ($running_number + 1) . "." .$fileextension;
					$stmt = $conn->prepare("UPDATE users SET logo_url = ? WHERE credential_id = ?");
					$stmt->bind_param("si", $logo_url, $serialid);
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
	}
	die(json_encode($message));


?>