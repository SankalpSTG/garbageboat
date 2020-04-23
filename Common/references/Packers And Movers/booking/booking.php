<?php
	session_start();
	if(!isset($_SESSION["email_id"])){
		header("Location:../login/login.php");
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
			<div class="form-container">
				<form method="post" action="/includes/booking.php">
					<div class="form-header">
						<h1>Booking</h1>
					</div>
					<div class="form-body">
						<input name="day" class="simpledateinput" type="text" placeholder="Day">
						<input name="month" class="simpledateinput" type="text" placeholder="Month">
						<input name="year" class="simpledateinput" type="text" placeholder="Year">
						<input name="hours" class="simpledateinput" type="text" placeholder="Hours"><br>
						<input name="srcpin" class="simpleinput" type="text" placeholder="Source Pincode"><br>
						<input name="srcadd" class="simpleinput" type="text" placeholder="Source Address"><br>
						<input name="dstpin" class="simpleinput" type="text" placeholder="Destination Pincode"><br>
						<input name="dstadd" class="simpleinput" type="text" placeholder="Destination Address"><br>
						<input name="distance" id="distapprox"class="simpleinput" type="text" placeholder="Distance in Kms(Approx)" onkeyup="trucksizechanged();"><br>
						<select name="truckcost" id="trucksize" class="simpleinput" onchange="trucksizechanged(); truckchanged();">
							<option value="0">Select Truck Size</option>
							<option value="1000">Small(1.5 ton)</option>
							<option value="2000">Medium(2 ton)</option>
							<option value="3000">Large(4 ton)</option>
							<option value="5000">XL(7 ton)</option>
							<option value="10000">XXL(16 ton)</option>
							<option value="20000">XXXL(25 ton)</option>
						</select>
						<input type="hidden" id="trucksizelit" name="trucksizelit">
						<hr>
							<label><h3>Estimated Cost</h3></label><br>
						<input name="totalcost" id="estimatedcost" class="simpleinput" type="text" placeholder="Estimated Cost">
					</div>
					<div class="form-footer">
						<input class="simpleinputsubmit" type="submit" name="submit" placeholder="submit" value="submit">
					</div>
				</form>
			</div>
		</div>
		<footer>
			&copy; Omkar & Kunal
		</footer>
	</body>
</html>