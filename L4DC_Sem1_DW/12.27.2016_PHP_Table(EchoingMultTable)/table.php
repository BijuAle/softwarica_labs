<?php
echo "<table border = '1'>";
	for ($i=1; $i < 50; $i++) { 
		echo "<tr>";
			$prod = $i*5;
			echo "<td>$i*5=</td>";
			echo "<td>$prod</td>";
		echo "</tr>";
	}
echo "</table>";
?>