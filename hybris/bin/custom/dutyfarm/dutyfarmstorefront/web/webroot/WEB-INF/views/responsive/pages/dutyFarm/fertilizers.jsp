<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fertilizer List</title>
</head>
<body>
	<h1>Fertilizer Listing</h1>
	<ul>
		<c:forEach var="fertilizer" items="${fertilizers}">
        			<li>${fertilizer.name}</li>
        </c:forEach>
	</ul>
</body>
</html>