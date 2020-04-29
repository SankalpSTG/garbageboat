<?php
	function uploadFile($file, $runningno, $path){
		$target_dir = $_SERVER["DOCUMENT_ROOT"]."/garbageboat/data/images/".$path;
		$target_file = $target_dir.basename($file["name"]);
		$check = json_encode(getImageSize($file["tmp_name"]));
		if($check === false){
			return 0;
		}else{
			if(file_exists($target_file)){
				return 2;
			}else{
				if($file["size"] > 2000000) {
					return 3;
				}else{
					$imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));
					if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg") {
						return 4;
					}else{
						
						$target_file = $target_dir.($runningno+1).".".$imageFileType;
						if (move_uploaded_file($file["tmp_name"], $target_file)) {
							return 1;
						} else {
							return 5;
						}
					}
				}
			}
		}
	}
	function fileUploaded($filekey){
		if(empty($_FILES)) {
			return false;       
		} 
		$filetocheck = $_FILES[$filekey];
		if(!file_exists($filetocheck['tmp_name']) || !is_uploaded_file($filetocheck['tmp_name'])){
			return false;
		}   
		return true;
	}
?>