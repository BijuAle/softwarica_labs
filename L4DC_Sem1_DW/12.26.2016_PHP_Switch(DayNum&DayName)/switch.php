<?php
//decision making statements
//switch case statement

if (isset($_POST['btnSubmit'])) {
	$day = $_POST['txtDay'];
	switch ($day){
		case "Sunday": echo 1;
		break;
		case "Monday": echo 2;
		break;
		case "Tuesday": echo 3;
		break;
		case "Wednesday": echo 4;
		break;
		case "Thursday": echo 5;
		break;
		case "Friday": echo 6;
		break;
		case "Saturday": echo 7;
		break;		
		default: echo "Invalid entry";
	}
}

?>

<!DOCTYPE html>
<html>
<head>
	<title>Day Printer</title>
	<meta name="author" content="Biju Ale">
</head>
<body>
	<form method="post" action="switch.php">
		<label>Enter Day</label><input type="text" name="txtDay">
		<input type="submit" name="btnSubmit">
	</form>
</body>
</html>