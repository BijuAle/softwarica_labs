<?php

echo $fname = $_FILES['file']['name'];
echo $size = $_FILES['file']['size'];
echo "<br>".$ext = pathinfo($fname, PATHINFO_EXTENSION);
if($ext == 'gif'|| $ext =='png' ||$ext =='jpg'){
move_uploaded_file($_FILES['file']['tmp_name'],"Images/".$fname);	
}else{
	echo "Invalid File Format.";
}

?>