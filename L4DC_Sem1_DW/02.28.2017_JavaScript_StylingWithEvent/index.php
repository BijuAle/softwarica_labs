<!DOCTYPE html>
<html>
<head>
	<title>JS</title>
</head>
<body>
<h1 id = "test1" onmousedown="myFun()">Welcome</h1>
<p id = "test2" onclick = "document.getElementById('test2').innerHTML = Date()">Click me</p><!-- No need to write function for single effect -->
<script type="text/javascript">
	document.getElementById("test1").style.color = "red";
	var d = new Date();
	document.getElementById("test1").innerHTML = d.getYear();

	/*Array n Javascript*/
	var myArray = ['js', 'php', 'html'];
	/*document.getElementById("test1").innerHTML = myArray[2];*/
	for (var i= 0; i<myArray.length; i++) {
		document.writeln(myArray[i]);
	}
	function myFun(){
		document.getElementById("test1").style.color = "blue";
		document.getElementById("test1").style="color:blue;font-size:30px;";
	}
</script>
</body>
</html>