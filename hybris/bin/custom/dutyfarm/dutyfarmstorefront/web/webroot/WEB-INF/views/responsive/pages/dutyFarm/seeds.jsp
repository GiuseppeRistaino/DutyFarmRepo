<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seed List</title>
</head>
<body>
	<h1>Seed Listing</h1>
	<ul>
		<c:forEach var="seed" items="${seeds}">
        			<li>${seed.name}</li>
        </c:forEach>
	</ul>
</body>
</html>