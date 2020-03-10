<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vegetable List</title>
</head>
<body>
	<h1>Vegetable Listing</h1>
	<ul>
		<c:forEach var="vegetable" items="${vegetables}">
        			<li>${vegetable.name}</li>
        </c:forEach>
	</ul>
</body>
</html>