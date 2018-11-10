<!DOCTYPE html>
<html>
<head>
	<title>Admin User</title>
	<meta name="author" content="Biju Ale">
</head>
<body>
<h1>Admin User</h1>
</body>
</html>

<?php 
include("config.php");
session_start();
$id = $_SESSION['id'];
$query_select = "SELECT * FROM tbl_users WHERE id = $id";
$result = $conn->query($query_select);
echo "<table border = '1'>";
while($data = $result->fetch_assoc()){
	/*echo "<tr><td>".$data['id']."</td><td>"
		.$data['user']."</td><td>"
		.$data['password']."</td><td>"
		.$data['type']."</td>"*/
}
?>
