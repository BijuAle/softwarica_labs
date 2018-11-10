<?php 
echo "<table border = '1'>";
	for ($row=0; $row < 8; $row++) {		
		echo "<tr>";
			for ($col=0; $col < 8; $col++) { 
				if (($col + $row) % 2 ==0) {
					echo "<td height = '50p' width = '50p' bgcolor = '#ffffff'></td>";
				}else{
					echo "<td height = '50p' width = '50p' bgcolor = '#000000'></td>";
				}
				
			}
		echo "</tr>";
	}
echo "</table>";
?>

<!DOC>