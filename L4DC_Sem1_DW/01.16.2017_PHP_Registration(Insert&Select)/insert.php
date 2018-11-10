<?php 
include("config.php");

if (isset($_POST['btnSubmit'])) {

	$un = $_POST['txtUsername'];
	$phone = $_POST['txtPhone'];

	$query = "INSERT INTO tbl_soft(id, un, phone) VALUES (NULL, '$un', '$phone')";
	$conn->query($query);
	
	header("location:select.php?var='$un'");
}

?>