<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SeedVariant List</title>
</head>
<body>
	<h1>SeedVariant Listing</h1>
	<ul>
		<c:forEach var="seedVariant" items="${seedVariants}">
        			<li>${seedVariant.name}</li>
        </c:forEach>
	</ul>
</body>
</html>