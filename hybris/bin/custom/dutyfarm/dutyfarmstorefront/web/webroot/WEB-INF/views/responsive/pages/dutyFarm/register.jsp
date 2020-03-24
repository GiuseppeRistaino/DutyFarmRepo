<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/responsive/user"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>

<c:url value="/j_spring_security_check" var="loginActionUrl" />

<template:page pageTitle="${pageTitle}">
    <body>
        <div class="register__section">
        	<c:url value="/login/register" var="registerActionUrl" />
        	<user:register actionNameKey="register.submit"
        		action="${registerActionUrl}" />
        </div>


    </body>
</template:page>
