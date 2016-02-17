<!-- show-values -->
<%@ page session="false" %>
<%@ page import="java.util.Enumeration" %>

<html>
<head>
<title>Result!</title>
</head>

<h1> Result: <%=request.getAttribute("result")%> </h1>
<a href=http://localhost:8080/Runtimes/>Return to Runtimes</a>

<p>
Runtimes:
<li>Selecion was O(n^2) time</li>
<li>Insertion was O(n^2) time</li>
<li>Merge was O(nlgn) time</li>
<li>Quick was O(n^2) time</li>
<li>Heap was O(nlgn) time</li>
<li>Counting was O(n+k) time</li>
<li>Radix was O(d(n+k)) time</li>
<li>Bubble was terrible</li>
</p>

<body bgcolor="#A8A8A8">

</body>

</html>

