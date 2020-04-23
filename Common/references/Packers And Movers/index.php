<?php
	session_start();
	
?>
<!DOCTYPE html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
	<head>
		<link rel="stylesheet" href="/plugins/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="/plugins/w3/w3.css" />
		<link rel="stylesheet" href="/plugins/custom/custom_style.css" />
		<script src="/plugins/custom/custom_style.js"></script>
		<link rel="shortcut icon" href="/includes/resources/images/icon/favicon4.ico" />
		<title>Omkar Packers & Movers</title>
		<?php
		if(isset($_GET["message"])){
			$message = $_GET["message"];
			echo "<script>alert('$message');</script>";
		}
		?>
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
			<div class="card-container">
				<div class="row card-grid">
					<div class="xcard col-sm-6">
						<a href="/register/register.php">Register</a>
					</div>
					<div class="xcard col-sm-6">
						<a href="/booking/booking.php">Booking Service</a>
					</div>
					<div class="xcard col-sm-6">
						<a href="/login/login.php">Login</a>
					</div>
					<div class="xcard col-sm-6">
						<a href="/feedback/feedback.php">Feedback</a>
					</div>
				</div>
			</div>
		</div>
		<footer>
			&copy; Omkar & Kunal
		</footer>
	</body>
</html>