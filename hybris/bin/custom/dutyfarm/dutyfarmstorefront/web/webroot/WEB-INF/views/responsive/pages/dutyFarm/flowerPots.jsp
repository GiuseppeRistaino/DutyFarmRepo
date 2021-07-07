<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlowerPot List</title>
</head>
<body>
	<h1>FlowerPot Listing</h1>
	<ul>
		<c:forEach var="flowerPot" items="${flowerPots}">
        			<li>${flowerPot.name}</li>
        </c:forEach>
	</ul>
</body>
</html>