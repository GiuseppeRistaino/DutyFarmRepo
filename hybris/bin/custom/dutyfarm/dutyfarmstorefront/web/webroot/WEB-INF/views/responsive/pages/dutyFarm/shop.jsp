<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/responsive/user"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<template:page pageTitle="${pageTitle}">
    <body>

        <div class="category-container">
            <c:forEach var="category" items="${categories}">
                <div class="category-cell">
                    <a href="/${fn:toLowerCase(message)}">
                    <img src="${category.picture.url}"/></a>
                    <a class="category-link" href="/${fn:toLowerCase(message)}">${category.code}</a>
                </div>
            </c:forEach>
        </div>

    </body>
</template:page>

<%--
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category List</title>
</head>
<body>
	<h1>Category Listing</h1>
	<ul>
		<c:forEach var="category" items="${categories}">
        			<li>${category.code}</li>
        </c:forEach>
	</ul>
</body>
</html>
--%>