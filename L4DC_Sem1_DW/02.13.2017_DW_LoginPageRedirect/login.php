<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta name="author" content="Biju Ale">
</head>
<body>
	<h1>Login</h1>
	<form method = "POST">
		<label>Account</label><input type="text" name="txtAccount">
		<label>Password</label><input type="password" name="txtPassword">
		<input type="submit" name="btnSubmit">
	</form>
</body>
</html>

<?php 
if (isset($_POST['btnSubmit'])) {
	include("config.php");
	$acc = $_POST['txtAccount'];
	$pwd = $_POST['txtPassword'];

	if ($acc==""||$pwd == "") {
		echo "Enter Account and Password!";
	}
	$query_check = "SELECT * FROM tbl_users WHERE acc = '$acc' AND pwd ='$pwd'";
	$result = $conn->query($query_check);
	if ($result->num_rows ==1) {
		echo "Logged In";
		while($data = $result->fetch_assoc()){
			$type = $data['type'];
			$id = $data['id']; 
			echo $type;
		}
		session_start();
		$_SESSION['log'] = $type;
		$_SESSION['id'] = $id;
		header('Location:Welcome.php');
	}else{
		echo "Invalid UserID or password";
	}

}

?>