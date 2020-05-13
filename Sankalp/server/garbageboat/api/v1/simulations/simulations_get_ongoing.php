<?php
require("../database/dbh.inc.php");

	$message["error"] = true;
	$message["error_message"] = "Require all parameters";
	if(isset($_POST["serial_id"]) ){
		$serial_id = (int)$_POST["serial_id"];
		if(empty($serial_id)){
			$message["error"] = true;
			$message["error_message"] = "Required all parameters";
			die(json_encode($message));
		}else{
			$stmt = $conn->prepare("select * from projects where credential_id = ? and serial_id not in(select project_id from simulations where project_id in(select serial_id from projects where credential_id = ?));");
			$stmt->bind_param("ii", $serial_id, $serial_id);
			$stmt->execute();
			$result = $stmt->get_result();
			$stmt->close();
			if(mysqli_num_rows($result) == 0){
				$message["error"] = true;
				$message["error_message"] = "No projects without ongoing simulations";
				die(json_encode($message));
			}else{
				$data = [];
				while($row = mysqli_fetch_assoc($result)){
					array_push($data, $row);
				}
				$message["error"] = false;
				$message["error_message"] = "success";
				$message["data"] = $data;
				die(json_encode($message));
			}
		}
	}die(json_encode($message));
?>