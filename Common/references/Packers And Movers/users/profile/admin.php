<?php
	session_start();
	if(isset($_SESSION["email_id"])){
	}
?>
<!DOCTYPE html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
	<head>
		<link rel="stylesheet" href="/plugins/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/plugins/w3/w3.css" />
		<link rel="stylesheet" href="plugins/custom/custom_style.css" />
		<script src="plugins/custom/custom_style.js"></script>
		<link rel="shortcut icon" href="/includes/resources/images/icon/favicon4.ico" />
		<title>Omkar Packers & Movers</title>
	</head>
	<body onresize="" onload="afterload();">
		<header>
			<div class="header-cont">
				<a href="/index.php">
				<img src="resources/images/general/logo_transparent.png" height=75px>
				</a>
			</div>
		</header>
		<div class="c-container">
			<table>
				<tr>
					<th>Serial ID</th>
					<th>Email ID</th>
					<th>Source Pincode</th>
					<th>Source Address</th>
					<th>Destination Pincode</th>
					<th>Destination Address</th>
					<th>Distance</th>
					<th>Truck Size</th>
					<th>Truck Cost</th>
					<th>Total Cost</th>
					<th>Date of transfer</th>
				</tr>
				<?php
					require $_SERVER["DOCUMENT_ROOT"]."/includes/dbh.inc.php";
					$stmt = $conn->prepare("SELECT * FROM bookings");
					$stmt->execute();
					$result = $stmt->get_result();
					$stmt->close();
					
					while($row = mysqli_fetch_assoc($result)){
						echo "<tr>";
						echo "<td>".$row['serial_id']."</td>";
						echo "<td>".$row['email']."</td>";
						echo "<td>".$row['src_pin']."</td>";
						echo "<td>".$row['src_add']."</td>";
						echo "<td>".$row['dst_pin']."</td>";
						echo "<td>".$row['dst_add']."</td>";
						echo "<td>".$row['distance']."</td>";
						echo "<td>".$row['truck_size']."</td>";
						echo "<td>".$row['truck_cost']."</td>";
						echo "<td>".$row['total_cost']."</td>";
						echo "<td>".$row['day']."/".$row['month']."/".$row['year']." At ".$row['hours'].":00 hours</td>";
						echo "</tr>";
					}
				?>
			</table>
		</div>
		<footer>
			&copy; Omkar & Kunal
		</footer>
	</body>
</html>