<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="cms" tagdir="/WEB-INF/tags/responsive/template/cms" %>


<link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="${commonResourcePath}/dutyFarm/css/carousel_new.css" />
<link rel="stylesheet" type="text/css" href="${commonResourcePath}/dutyFarm/css/style.css" />


<%-- LOGIN PAGE --%>
	<link rel="icon" type="image/png" href="${commonResourcePath}/dutyFarm/login/images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="${commonResourcePath}/dutyFarm/login/fonts/iconic/css/material-design-iconic-font.min.css">
	<link rel="stylesheet" type="text/css" href="${commonResourcePath}/dutyFarm/login/css/util.css">
	<link rel="stylesheet" type="text/css" href="${commonResourcePath}/dutyFarm/login/css/main.css">
<%-- END LOGIN PAGE --%>

<%-- PRODUCTS PAGE --%>
<%-- END PRODUCTS PAGE --%>

<%-- OLD
<link rel="stylesheet" type="text/css" href="${commonResourcePath}/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${commonResourcePath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${commonResourcePath}/bootstrap/css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="${commonResourcePath}/bootstrap/css/bootstrap-theme.min.css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic" />
<c:choose>
	<c:when test="${wro4jEnabled}">
		<link rel="stylesheet" type="text/css" media="all" href="${fn:escapeXml(contextPath)}/wro/all_responsive.css" />
		<link rel="stylesheet" type="text/css" media="all" href="${fn:escapeXml(contextPath)}/wro/${fn:escapeXml(themeName)}_responsive.css" />
		<link rel="stylesheet" type="text/css" media="all" href="${fn:escapeXml(contextPath)}/wro/addons_responsive.css" />
	</c:when>
	<c:otherwise>
		<link rel="stylesheet" type="text/css" media="all" href="${fn:escapeXml(themeResourcePath)}/css/style.css"/>

		<c:forEach items="${addOnCommonCssPaths}" var="addOnCommonCss">
			<link rel="stylesheet" type="text/css" media="all" href="${fn:escapeXml(addOnCommonCss)}"/>
		</c:forEach>
	</c:otherwise>
</c:choose>

<c:forEach items="${addOnThemeCssPaths}" var="addOnThemeCss">
	<link rel="stylesheet" type="text/css" media="all" href="${fn:escapeXml(addOnThemeCss)}"/>
</c:forEach>

<cms:previewCSS cmsPageRequestContextData="${cmsPageRequestContextData}" />
--%>