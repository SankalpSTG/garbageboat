<?php
	session_start();
	if(isset($_POST["submit"])){
		require "dbh.inc.php";
		
		$email = $_SESSION["email_id"];
		$day = $_POST["day"];
		$month = $_POST["month"];
		$year = $_POST["year"];
		$hours = $_POST["hours"];
		$srcpin = $_POST["srcpin"];
		$srcadd = $_POST["srcadd"];
		$dstpin = $_POST["dstpin"];
		$dstadd = $_POST["dstadd"];
		$distance = $_POST["distance"];
		$trucksizelit = $_POST["trucksizelit"];
		$truckcost = $_POST["truckcost"];
		$totalcost = $_POST["totalcost"];
		
		$stmt = $conn->prepare("INSERT INTO bookings (email, day, month, year, hours, src_pin, src_add, dst_pin, dst_add, distance, truck_size, truck_cost, total_cost) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		$stmt->bind_param("sssssssssssss", $email, $day, $month, $year, $hours, $srcpin, $srcadd, $dstpin, $dstadd, $distance, $trucksizelit, $truckcost, $totalcost);
		$stmt->execute();
		$stmt->close();
		header("Location: ../index.php?message=booking+successful");
		exit();
	}else{
		header("Location: ../index.php");
	}
?>