<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TreeVariant List</title>
</head>
<body>
	<h1>TreeVariant Listing</h1>
	<ul>
		<c:forEach var="treeVariant" items="${treeVariants}">
        			<li>${treeVariant.name}</li>
        </c:forEach>
	</ul>
</body>
</html>