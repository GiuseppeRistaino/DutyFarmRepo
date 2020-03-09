<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flower List</title>
</head>
<body>
	<h1>Flower Listing</h1>
	<ul>
		<c:forEach var="flower" items="${flowers}">
        			<li>${flower.name}</li>
        </c:forEach>
	</ul>
</body>
</html>