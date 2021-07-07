<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tree List</title>
</head>
<body>
	<h1>Tree Listing</h1>
	<ul>
		<c:forEach var="tree" items="${trees}">
        			<li>${tree.name}</li>
        </c:forEach>
	</ul>
</body>
</html>