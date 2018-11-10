<?php
include("config.php");
$id = $_GET['uid']; //11
$qqq = "delete from tbl_name where id='$id'";
$bonn->query($qqq);
header("location:index.php");
 ?>