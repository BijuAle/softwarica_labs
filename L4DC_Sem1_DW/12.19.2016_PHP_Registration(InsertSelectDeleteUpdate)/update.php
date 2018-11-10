<?php 
include("config.php");

$uid= $_GET['uid'];

$query = "select * from tbl_name where id='$uid'";
$result = $bonn->query($query);
$data = $result->fetch_array();
//print_r($data);


?>
 
 
<form method="post" action="update_action.php">
<input type="hidden" name="uid" value="<?php echo $uid; ?>" />
<p>Username<input type="text" name="un" value="<?php echo $data['un'] ?>" /></p>
<p>Address<input type="text" name="add" value="<?php echo $data['address']; ?>" /></p>
<p>email<input type="text" name="em" value="<?php echo $data['em']; ?>" /></p>
<p><input type="submit" name="sub" /></p>


</form>