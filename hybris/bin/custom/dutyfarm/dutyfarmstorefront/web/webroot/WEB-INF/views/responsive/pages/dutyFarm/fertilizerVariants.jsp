<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FertilizerVariant List</title>
</head>
<body>
	<h1>FertilizerVariant Listing</h1>
	<ul>
		<c:forEach var="fertilizerVariant" items="${fertilizerVariants}">
        			<li>${fertilizerVariant.name}</li>
        </c:forEach>
	</ul>
</body>
</html>