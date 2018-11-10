<?php
 if(isset($_COOKIE['login_count'])){
 	if( $_COOKIE['login_count']==5)
 	{
 		echo "You are blocked";
 		die();
 	}
 	
 }
?>

<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
</head>
<body>
<form method = "POST" action = "blockLogin.php">
	Username <input type="text" name="txtUsername">
	Password <input type="text" name="txtPassword">
	<input type="submit" name="btnSubmit" id = "btnSubmit">
</form>
</body>
</html>

