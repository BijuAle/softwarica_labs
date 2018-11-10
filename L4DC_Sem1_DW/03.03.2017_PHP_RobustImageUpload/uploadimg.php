<?php
$title = $_POST['txtTitle'];
$price = $_POST['txtPrice'];


$conn = new mysqli('localhost', 'root', '', 'mydb2');
$insert_query = "INSERT INTO tblparty(party_id, party_title, price, img) VALUES(null, '$title', '$price', 'aa')";
$conn->query($insert_query);
$currrent_insert_id = $conn->insert_id;


// to upload image --- code

$file_ext = pathinfo($_FILES['imgFile']['name'],PATHINFO_EXTENSION); // extension of the file
if($file_ext=='png' || $file_ext=='gif' || $file_ext=='jpg')
{
	$pic_new_name = "pic_".$currrent_insert_id."_party".".jpg";
	move_uploaded_file($_FILES['imgFile']['tmp_name'],"images/".$pic_new_name);
}



$update_query = "update tblparty set img='$pic_new_name' where party_id='$currrent_insert_id'";
$conn->query($update_query);

?>