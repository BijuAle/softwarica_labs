<?php
$conn = new mysqli('localhost', 'root', '', 'mydb2');
$select_query = "SELECT * FROM tblparty";
$result = $conn->query($select_query);
while($data = $result->fetch_assoc()){
	echo "<div>".$data['party_title']."---";
	echo $data['price']."----";
	echo "</div>";
	?>
	<img src='images/<?php echo $data['img']; ?>' width="200" />
	<?php	
	}
?>

