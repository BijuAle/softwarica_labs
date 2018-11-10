<!DOCTYPE html>
<html>
<head>
	<title>Welcome</title>
	<meta name="author" content="Biju Ale">
</head>
<body>
<?php
//echo $_SESSION['log'];
session_start();
if($_SESSION['log']=="admin"){
	header('Location:Admin.php');
	echo "Admin";
}else{
	header('Location:General.php');	
	echo "General";
}
?>
<h1>Welcome</h1>
</body>
</html>