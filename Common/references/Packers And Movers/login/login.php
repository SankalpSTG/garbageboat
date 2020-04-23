<?php
	session_start();
	if(isset($_SESSION["email_id"])){
		if($_SESSION["user_type"] == "admin"){
			header("Location: ../users/profile/admin.php");
			exit();
		}else{
			header("Location: ../index.php");
		}
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
				<form method="post" action="/includes/login.php">
					<div class="form-header">
						<h1>Sign In</h1>
					</div>
					<div class="form-body">
						<input class="simpleinput" name="email" type="email" placeholder="Email ID"><br>
						<input class="simpleinput" name="password" type="password" placeholder="password"><br>					
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