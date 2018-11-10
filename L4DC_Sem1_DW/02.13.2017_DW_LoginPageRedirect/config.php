<?php
define("HOST_NAME", "localhost" );
define("HOST_USER", "root");
define("HOST_PASSWORD", "");
define("DBNAME", "db_soft2");

$conn = new mysqli(HOST_NAME, HOST_USER, HOST_PASSWORD, DBNAME);
if($conn->connect_error){
echo "Connection failed. ".$connect_error;
}
?>
