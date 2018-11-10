<html>
<head>
	<title>Days</title>
	<meta name="author" content="Biju Ale">
</head>
<body>
	<form method = "POST" action = "day.php">
		Enter day number <input type="number" name="txtDayNo">
		<input type="submit" name="btnSubmit">

		<?php 
		$options= array("Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday");		
		if (isset($_POST['btnSubmit'])) {
			$count = $_POST['txtDayNo'];
			echo "<SELECT>";
			for ($i=0; $i < $count; $i++) { 
			echo "<option>$options[$i]</option>";
			}
			echo "</SELECT>";
		}
		?>
	</form>
</body>
</html>