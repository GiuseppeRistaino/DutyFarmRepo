<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/responsive/user"%>


<div class="register__section">
	<c:url value="/login/register" var="registerActionUrl" />
	<user:register actionNameKey="register.submit"
		action="${registerActionUrl}" />
</div>

<%--
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h1>Register Page</h1>

    <form:form action="register/newcustomer" modelAttribute="RegisterForm">
        <label for="firstName">First name: </label>
        <input type="text" id="firstName" name="firstName"><br><br>
        <label for="lastName">Last name: </label>
        <input type="text" id="lastName" name="lastName"><br><br>
        <label for="email">E-mail: </label>
        <input type="text" id="email" name="email"><br><br>
        <label for="pwd">Password: </label>
        <input type="text" id="pwd" name="pwd"><br><br>
        <input type="submit" value="Submit">
    </form:form>

</body>
</html>
--%>