<?php 
$count = 1;
if (isset($_POST['btnSubmit'])) {
	do {
		$prod = $_POST['txtNum'] * $count;

			$count++;
	
	} while ($count<=10);
}
?>

<!DOCTYPE html>
<html>
<head>
	<title>Multiples of 7</title>
	<meta name="author" content="Biju Ale">
</head>
<body>
	<form method = "post" action = "loopintegrated.php">
		Upto<input type="number" name="txtFinal">
		Multiple of <input type="number" name="txtNum">
		<input type="submit" name="btnSubmit">
	</form>
</body>
</html>