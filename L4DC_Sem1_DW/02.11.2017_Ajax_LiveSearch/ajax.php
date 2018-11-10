<?php
require_once "config.php";
//query  
$key = $_GET['key']; //a
//echo $key;


$con = new mysqli("localhost","root","","test");
$qu = "select * from tbl_test  where un like '$key%'"; 
 $result = $conn->query($qu);
 while($data = $result->fetch_assoc())
 {
   echo $data['un']."<br>";
 }

 
 ?>