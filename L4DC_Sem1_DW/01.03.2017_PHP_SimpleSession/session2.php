<?php 
session_start();
echo "Username: ".$_SESSION['username']."</br>";
echo "Password: ".$_SESSION['password'];
?>