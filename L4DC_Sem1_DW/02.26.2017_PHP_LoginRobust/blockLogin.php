<?php 
$username = $_POST['txtUsername'];
$password = $_POST['txtPassword'];
if ($username =="admin" && $password == "nepal") {
header("location:admin_dashboard.php");
	
}else{
	if(isset($_COOKIE['login_count']))
	{
     // already done mistake
		$counter = $_COOKIE['login_count']+1;
		setcookie("login_count", $counter,time()+60);
		//echo $_COOKIE['login_count'];

	}
	else
	{
   // first mistake
		setcookie("login_count",1,time()+60);
		

	}
	header("location:login.php");






}
?>
