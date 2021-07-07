<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="user" tagdir="/WEB-INF/tags/responsive/user"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>

<c:url value="/j_spring_security_check" var="loginActionUrl" />

<template:page pageTitle="${pageTitle}">
    <body>
        <div class="login-section">
            <user:login actionNameKey="login.login" action="${loginActionUrl}" />
        </div>


    </body>
</template:page>
