<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlowerPotVariant List</title>
</head>
<body>
	<h1>FlowerPotVariant Listing</h1>
	<ul>
		<c:forEach var="flowerPotVariant" items="${flowerPotVariants}">
        			<li>${flowerPotVariant.name}</li>
        </c:forEach>
	</ul>
</body>
</html>