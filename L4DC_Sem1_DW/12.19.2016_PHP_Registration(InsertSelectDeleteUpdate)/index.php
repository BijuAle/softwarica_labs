<?php
include("config.php");

if(isset($_GET['msg']))
{
echo "<h2>Inserted susscully!!</h2>";
}

$qq = "select * from tbl_name";
$result = $bonn->query($qq);

 ?>
<table border="1">
  <tr>
    <td>ID</td>
    <td>Username</td>
    <td>Address</td>
    <td>Email</td>
    <td>Action</td>
  </tr>
  
  <?php
  while($data = $result->fetch_array())
{

?>
   <tr>
    <td><?php echo  $data['id']; ?></td>
    <td><?php echo $data['un']; ?></td>
    <td><?php echo $data['address']; ?></td>
    <td><?php echo $data['em']; ?></td>
    <td><a href="delete.php?uid=<?php echo $data['id']; ?> ">DELETE</a>
	<a href="update.php?uid=<?php echo $data['id']; ?>">UPDATE</a>
	
	
	</td>
  </tr>
    
  <?php } ?>
    

  


</table>
 
 
 
 
 
<form method="post" action="action.php">

<p>Username<input type="text" name="un" /></p>
<p>Address<input type="text" name="add" /></p>
<p>email<input type="text" name="em" /></p>
<p><input type="submit" name="sub" /></p>


</form>