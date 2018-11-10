<?php 
//indexed array
$a = array(1,2,3,4,5);
$b = array("dw","php","javascript");
echo $a[3]."<br/>";
echo $b[2];

echo "<hr/>";
echo "<ul>";
foreach($a as $eachValue){
	echo "<li>".$eachValue."</li>";
}
echo "</ul>";

echo "<hr/>";
print_r($b);

//associative array
echo "<hr/>";
$c = array(1 =>5 , 2=>10, 'php'=>20,10=>'dw' );
echo $c['php'];
foreach ($c as $eachValue) {
	echo $eachValue."<br>";
}
echo "<hr/>";
foreach ($c as $key => $value) {
	echo $key.": ".$value."<br>";
}

//3.multidimensional array
echo "<hr/>";
$ma = array(
	array(1,2,3,4),
	array('a','b','c','d'),
	array('dw','php','javascript','jquery')
)	`;
echo $ma[1][2];

for ($row=0; $row < count($ma) ; $row++) { 
	for ($col=0; $col < count($ma[0]); $col++) { 
		echo $ma[$row][$col];
		echo "<br>";	
	}
}
?>