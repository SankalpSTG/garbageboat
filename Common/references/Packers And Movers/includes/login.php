<?php
	session_start();
	if(isset($_POST["submit"])){
		require "dbh.inc.php";
		
		$email = $_POST["email"];
		$password = $_POST["password"];
		
		$stmt = $conn->prepare("SELECT password, user_type FROM credentials WHERE email_id = ?");
		$stmt->bind_param("s", $email);
		$stmt->execute();
		$result = $stmt->get_result();
		$stmt->close();
		if(mysqli_num_rows($result) ==  1){
			$row = mysqli_fetch_assoc($result);
			if(password_verify($password, $row["password"])){
				$_SESSION["email_id"] = $email;
				$_SESSION["user_type"] = $row["user_type"];
				if($row["user_type"] == "admin"){
					header("Location: ../users/profile/admin.php");
					exit();
				}else{
					header("Location: ../index.php?message=login+successful");
					exit();
				}
			}else{
				header("Location: ../index.php?message=invalid+password");
				exit();
			}
		}else if(mysqli_num_rows($result) > 1){
			header("Location: ../index.php?message=Database+Compromised");
			exit();
		}else{
			header("Location: ../index.php?message=no+user+found");
			exit();
		}
	}else{
		header("Location: ../index.php");
	}
?>