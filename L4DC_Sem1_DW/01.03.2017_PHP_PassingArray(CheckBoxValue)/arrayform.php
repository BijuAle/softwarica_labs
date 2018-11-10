<?php
if (isset($_POST['btnSubmit'])) {
	$hob = $_POST['check'];
	foreach ($hob as $value) {
		echo $value."<br>";
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
		<form method = "POST" action = "arrayform.php" >
			<input type="checkbox" name="check[]" value = "Sports">Sports
			<input type="checkbox" name="check[]" value = "Music">Music
			<input type="checkbox" name="check[]" value = "Travel">Travel
			<input type="checkbox" name="check[]" value = "Movies">Movies
			<input type="checkbox" name="check[]" value = "Coding">Coding
			<input type="submit" name = "btnSubmit" value = "Check">
		</form>
	</body>
</html>

