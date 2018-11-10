<?php

include("config.php");

$username = $_POST['un'];
$add = $_POST['add'];
$email = $_POST['em'];

 $abcd = "insert into tbl_name(id,un,address,em) 
 values(NULL,'$username','$add','$email')";
 $bonn->query($abcd);

header("location:index.php?msg=insert");
 ?>