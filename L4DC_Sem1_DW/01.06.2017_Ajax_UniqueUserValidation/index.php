<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="author" content="Biju Ale">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>

<script type="text/javascript">
function loadme(){
	var txt =  document.getElementById('txt').value;
	var req;
	if(window.XMLHttpRequest)
	{
		req = new XMLHttpRequest();
		
	}
	else req = new ActiveXObject("Microsoft.XMLHTTP");
	req.onreadystatechange = function()
	{
		if(req.readyState==4)
		{
			document.getElementById('mydiv').innerHTML = req.responseText;
		}
	}
req.open("GET", "checkExistingUsername.php?word="+txt, true)
req.send();
}

</script>

</head>

<body>
<input type = "text" onkeyup = "loadme()" id = "txt"/>
<div id = "mydiv"></div>
</body>
</html>