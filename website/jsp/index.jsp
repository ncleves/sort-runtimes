<!-- index -->
<html>

<head>
<title>Runtimes!</title>
</head>

<body>
<h1>Welcome to Runtimes!</h1>

<body bgcolor="#D0D0D0">

<p> Want to sort your data and know how long it took to sort it? </p>
<p> Select a file and sort below! </p>

<form method="post" action="controller" enctype="multipart/form-data">
	Text File (.txt only): <input type="file" name="fileUpload"/><br/>
	<hr/>
	Sorts: 
	<ul>
		<li>Selection<input type="radio" name="sorts" value="1"/></li>
		<li>Insertion<input type="radio" name="sorts" value="2"/></li>
		<li>Merge<input type="radio" name="sorts" value="3"/></li>
		<li>Quick<input type="radio" name="sorts" value="4"/></li>
		<li>Heap<input type="radio" name="sorts" value="5"/></li>
		<li>Radix<input type="radio" name="sorts" value="6"/></li>
		<li>Bubble<input type="radio" name="sorts" value="7"/></li>
	<hr/>
	<input type="reset" name="clearButton" value="Reset"/>
	<input type="submit" name="submitButton" value="Sort!"/>
</form>

</body>

</html>