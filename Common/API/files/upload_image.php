<?php
	require("../database/dbh.inc.php");
	require("upload_image.inc.php");
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";
	if(fileUploaded("logo")){
		$file= $_FILES["logo"];
		$upload_status = uploadFile($file, 101, "randomimage/");
		if($upload_status == 0){
			$message["error"] = true;
			$message["error_message"] = "No File Received";
		}else if($upload_status == 2){
			$message["error"] = true;
			$message["error_message"] = "File Already Exists";
		}else if($upload_status == 3){
			$message["error"] = true;
			$message["error_message"] = "Size should be less than 500Kb";
		}else if($upload_status == 4){
			$message["error"] = true;
			$message["error_message"] = "Only JPG, PNG and JPEG formats are allowed";
		}else if($upload_status == 5){
			$message["error"] = true;
			$message["error_message"] = "Failed to upload file";
		}else if($upload_status == 1){
			$message["error"] = false;
			$message["error_message"] = "Success";
		} 
		die(json_encode($message));
	}
	die(json_encode($message));
?>