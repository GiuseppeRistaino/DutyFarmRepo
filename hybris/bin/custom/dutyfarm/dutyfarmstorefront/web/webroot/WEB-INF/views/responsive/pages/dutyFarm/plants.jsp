<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plant List</title>
</head>
<body>
	<h1>Plant Listing</h1>
	<ul>
		<c:forEach var="plant" items="${plants}">
        			<li>${plant.name}</li>
        </c:forEach>
	</ul>
</body>
</html>