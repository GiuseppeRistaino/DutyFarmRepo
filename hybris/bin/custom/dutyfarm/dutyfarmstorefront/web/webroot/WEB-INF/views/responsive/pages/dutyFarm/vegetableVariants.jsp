<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VegetableVariant List</title>
</head>
<body>
	<h1>VegetableVariant Listing</h1>
	<ul>
		<c:forEach var="vegetableVariant" items="${vegetableVariants}">
        			<li>${vegetableVariant.name}</li>
        </c:forEach>
	</ul>
</body>
</html>