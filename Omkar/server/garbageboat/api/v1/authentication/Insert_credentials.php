<?php
require ("../database/dbh.inc.php");
	
	$message["error"] = true;
	$message["error_message"] = "Required all parameters";	
	
	if(isset($_POST["emailid"]) && isset($_POST["mobileno"])){
		$emailid = mysqli_real_escape_string($conn, $_POST["emailid"]);
		$mobileno = mysqli_real_escape_string($conn, $_POST["mobileno"]);
		
		if(empty($emailid) || empty($mobileno)){
			$message["error"] = true;
			$message["error_message"] = "Please enter e-msail or mobile no.";
			die(json_encode($message));	
		}else{
			if((filter_var($emailid, FILTER_VALIDATE_EMAIL) === false) || !preg_match('/^[0-9]{10}+$/', $mobileno)){
				$message["error"] = true;
				$message["error_message"] = "Invalid e-mail or mobile no.";
				die(json_encode($message));
			}else{
				$stmt = $conn->prepare("SELECT serial_id FROM credentials WHERE email_id = ?");
				$stmt->bind_param("s", $emailid);
				$stmt->execute();
				$result = $stmt->get_result();
				$stmt->close();
				if(mysqli_num_rows($result) > 0){	
					$row = mysqli_fetch_assoc($result);
					$message["error"] = false;
					$message["error_message"] = "User already exist";
					$data["serial_id"] = $row["serial_id"];
					$data["email_id"] = $emailid;
					$message["data"]=$data;
					die(json_encode($message));
				}else{
					$stmt = $conn->prepare("INSERT INTO credentials (email_id, mobile_no) VALUES (?, ?)");
					$stmt->bind_param("si", $emailid, $mobileno);
					$stmt->execute();
					$stmt->close();
					$stmt = $conn->prepare("SELECT serial_id FROM credentials WHERE email_id = ?");
					$stmt->bind_param("s", $emailid);
					$stmt->execute();
					$result = $stmt->get_result();
					$stmt->close();
					if(mysqli_num_rows($result) > 0){	
						$row = mysqli_fetch_assoc($result);
						$message["error"] = false;
						$message["error_message"] = "Success";
						$data["serial_id"] = $row["serial_id"];
						$data["email_id"] = $emailid;
						$message["data"]=$data;
						die(json_encode($message));
					}else{
						$message["error"] = true;
						$message["error_message"] = "Failed to add user";
						die(json_encode($message));
						
					}
				}
			}
		}
	}
	die(json_encode($message));
?>