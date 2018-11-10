<table border = "1">
	<?php
	require_once "config.php";
	$query  = "SELECT * FROM tbl_soft";
	echo "	<th>ID</th>
	<th>Username</th>
	<th>Phone</th>";
	$result = $conn->query($query);

	while($data = $result->fetch_assoc()){
		echo "<tr>
		<td>$data[id]</td>
		<td>$data[un]</td>
		<td>$data[phone]</td>
		<td><a href='update.php?id=$data[id]'>Update</a></td>
	</tr>";
}
?>
</table>
<?php
$uid = $_GET['id'];
$query2  = "SELECT * FROM tbl_soft WHERE id = '$uid'";
$result2 = $conn->query($query2);

while($data2 = $result2->fetch_assoc()){
	$id = $data2['id'];
	$un = $data2['un'];
	$phone = $data2['phone'];
}
?>

<form method = "POST" name = "updateForm">
	<input type = "text" name = "txtID" value = "<?php echo $id?>" disabled= "disabled"/>
	<input type = "text" name = "txtUsername" value = "<?php echo $un?>"/>
	<input type = "text" name = "txtPhone" value = "<?php echo $phone?>"/>
	<input type = "submit" name = "btnUpdate" value = "Update" onclick= "setUpdateValues()">
</form>


<script type="text/javascript">
	var new_username;
	var new_phone;
	var id;
	function setUpdateValues(){
		new_username = document.forms["updateForm"]["txtUsername"].value
		new_phone = document.forms["updateForm"]["txtPhone"].value
		id = document.forms["updateForm"]["txtID"].value
	}

	<?php
	require_once "config.php";
	if(isset($_POST['btnUpdate'])){
		$update_query = "UPDATE tbl_soft SET un = 'new_username', phone='new_phone' WHERE id = 'id'";
		$conn->query($update_query);
	}
	?>
	
</script>
