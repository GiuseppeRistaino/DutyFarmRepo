<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlowerVariant List</title>
</head>
<body>
	<h1>FlowerVariant Listing</h1>
	<ul>
		<c:forEach var="flowerVariant" items="${flowerVariants}">
        			<li>${flowerVariant.name}</li>
        </c:forEach>
	</ul>
</body>
</html>