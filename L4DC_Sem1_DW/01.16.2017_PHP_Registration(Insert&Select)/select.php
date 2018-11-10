<?php 
include ("config.php");
if (isset($_GET['var'])) {
	echo "<h2>INSERTED</h2>";
	
	$query = "SELECT * FROM tbl_soft";
	$result = $conn->query($query);
	
	echo "<table border = '1'>";
	while ($data = $result->fetch_assoc()) {
			/*echo $data['id']."<br>";
			echo $data['un']."<br>";
			echo $data['phone']."<br>";
			*/
			echo "<tr>";
				echo "<td>$data[id]</td>";
				echo "<td>$data[un]</td>";
				echo "<td>$data[phone]</td>";
			echo "</tr>";		
		}	

	echo "</table>";

	/*
	foreach ($$r as $key) {
		echo "<>";
	}
	*/

}
?>