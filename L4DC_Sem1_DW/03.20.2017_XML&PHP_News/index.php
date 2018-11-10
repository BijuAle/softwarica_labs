<?php 

 /*$xml = simplexml_load_file("db.xml");
 foreach ($xml->student as $student) {
 	echo $student->email;
 	echo $student->name;
 }*/

 $xml = simplexml_load_file("bbc.xml");
 foreach ($xml->channel as $channel) {
 	foreach ($channel->item as $item) {
 		echo "<h1>".$item->title."</h1>";
 		echo $item->description;
 		$url = $item->link;
 		echo "<a href = '$url'>Read more...</a>";
 	}
 }
 ?>