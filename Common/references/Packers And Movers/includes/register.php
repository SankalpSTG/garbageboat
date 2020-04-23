<?php
	if(isset($_POST["submit"])){
		require "dbh.inc.php";
		
		$name = $_POST["fullname"];
		$email = $_POST["email"];
		$mobileno = $_POST["mobileno"];
		$country = $_POST["country"];
		$pincode = $_POST["pincode"];
		$password = $_POST["password"];
		
		$stmt = $conn->prepare("INSERT INTO credentials (email_id, password, name, mobile, country, pincode) VALUES(?, ?, ?, ?, ?, ?)");
		$stmt->bind_param("ssssss", $email, $password, $name, $mobileno, $country, $pincode);
		$stmt->execute();
		$stmt->close();
		header("Location: ../index.php?message=registration+successful");
		exit();
	}else{
		header("Location: ../index.php");
	}
?>