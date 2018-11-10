<?php 
if (isset($_POST['btnSubmit'])) {
$row =  $_POST['txtRow'];
$column = $_POST['txtColumn'];
echo "<table>";
for ($i=1; $i < $row; $i++) {
echo "<tr>"; 
	for ($j=1; $j < $column; $j++) { 
		if (($row+$column)%2==0) {
			echo "<td height ='30' width = '30' bgcolor='blue'>$i*$j=".$i*$j."</td>";
		}
		else{
			echo "<td height ='30' width = '30' bgcolor='green'>$i*$j=".$i*$j."</td>";
		}
	}
echo "</tr>";
}
echo "</table>";

}

?>

<!DOCTYPE html>
<html>
<head>
	<title>Chess Board</title>
	<meta name="author" content="Biju Ale">
</head>
<body>
<form method = 'POST' action = 'chessboard.php'>
	<input type="number" name="txtRow">
	<input type="number" name="txtColumn">
	<input type="submit" name="btnSubmit">
</form>

</body>
</html>