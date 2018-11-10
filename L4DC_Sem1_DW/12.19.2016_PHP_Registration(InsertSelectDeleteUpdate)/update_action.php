<?php

include("config.php");
$uid  = $_POST['uid'];
$un = $_POST['un'];
$add = $_POST['add'];
$em = $_POST['em'];




$aue = "update tbl_name set un='$un', address='$add', em='$em' where id='$uid'";
 $bonn->query($aue);
 header("location:index.php");
 
 ?>