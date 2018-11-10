<?php 

$conn = new mysqli("localhost", "root", "","db_childrenparty4u");
if(isset($_GET['s']))
{
$currentYear = $_GET['year']; // current year
$currentMonth = $_GET['month'];

}
else
{
$currentYear = date('Y'); // current year
$currentMonth = date('m'); // current month
}
$dateFormat = $currentYear.'-'.$currentMonth;



$query = "SELECT * FROM tbl_party2 WHERE book_date LIKE '$dateFormat%'";
$result = $conn->query($query);
while($data = $result->fetch_assoc()){
	echo $data['type'];
	echo $data['book_date']."</br>";
}

?>

<form>
	Year<select name = "year">
	<option>2017</option>
	<option>2018</option>
	<option>2019</option>
	<option>2020</option>
</select>

Month<select name = "month">
<option value = "01">Jan</option>
<option value = "02">Feb</option>
<option value = "03">Mar</option>
<option value = "04">Apr</option>
<option value = "05">May</option>
<option value = "06">Jun</option>
</select>
<input type="submit" name="s">
</form>
