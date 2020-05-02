<?php
	echo password_hash($_POST["user_password"], PASSWORD_DEFAULT);
?>