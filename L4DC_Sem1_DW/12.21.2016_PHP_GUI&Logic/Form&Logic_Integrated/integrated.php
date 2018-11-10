<?php 

	//decision making statements
	//1. if stattement
if (isset($_POST['btnSubmit'])) {
	$country = $_POST['txtCountry'];
	$age = $_POST['txtAge'];
	
	if ($country === "Nepal" & $age>=20) {
		echo "Eligible";
	}else{
		echo "Not eligible";
	}
}


?>

<!DOCTYPE html>
<html>
<head>
	<title>Form</title>
	<meta name="author" content="Biju Ale">
</head>
<body>
	<form method="post" action="integrated.php">
		<label>Enter Name</label><input type="text" name="txtCountry"><br>br
		<label>Enter Age</label><input type="text" name="txtAge"><br>
		<input type="submit" name="btnSubmit">
	</form>

</body>
</html>