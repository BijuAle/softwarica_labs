<?php
$conn = new mysqli("localhost", "root", "", "mydb");

$value = $_GET['word'];
/*$query = "select * FROM mytbl WHERE username = '$value'";
$result = $conn->query($query);
while($data =$result->fetch_array()){
echo $data['username'];
}*/
$pp = "SELECT * FROM mytbl WHERE username = '$value'";
$res = $conn->query($pp);
$num = $res->num_rows;
echo $num;
if ($num>0){
	echo "Username already exists";
}
?> 