<?php 
session_start();
if (!isset($_SESSION['count'])){
	$_SESSION['count']=0;
}else{
	if ($_SESSION['count']=10) {
		$_SESSION['count']=0;

	}else{
		$_SESSION['count']++;	
	}
}
echo $_SESSION['count'];
?>