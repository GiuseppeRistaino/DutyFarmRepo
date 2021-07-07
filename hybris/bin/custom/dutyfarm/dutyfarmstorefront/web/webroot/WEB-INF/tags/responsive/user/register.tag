<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ attribute name="actionNameKey" required="true" type="java.lang.String"%>
<%@ attribute name="action" required="true" type="java.lang.String"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement"%>
<%@ taglib prefix="ycommerce" uri="http://hybris.com/tld/ycommercetags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>

<spring:htmlEscape defaultHtmlEscape="true" />

<spring:url value="/login/register/termsandconditions" var="getTermsAndConditionsUrl"/>

<div class="limiter">
		<div class="container-login100 test-login" style="background-image: url('${commonResourcePath}/dutyFarm/login/images/register-background.jpg');">
			<div class="wrap-login100">
                <form:form method="post" commandName="registerForm" action="${action}" class="login100-form validate-form">

                    <span class="login100-form-logo">
                        <%--<i class="zmdi zmdi-landscape"></i>--%>
                        <img src="${commonResourcePath}/dutyFarm/images/DutyFarm_Logo.png"/>
                    </span>

                    <span class="login100-form-title p-b-34 p-t-27">
                    	Register
                    </span>

                    <div class="wrap-input100 validate-input">
		                <formElement:formSelectBox idKey="register.title"
                        		labelKey="register.title"
                        		path="titleCode" mandatory="true" skipBlank="false"
                        		skipBlankMessageKey="form.select.empty" items="${titles}" />
			        </div>

			        <div class="wrap-input100 validate-input">
                       <formElement:formInputBox idKey="register.firstName"
                                                labelKey="register.firstName" path="firstName" inputCSS="form-control"
                                                mandatory="true" />
                    </div>

                    <div class="wrap-input100 validate-input">
                       <formElement:formInputBox idKey="register.lastName"
                                                labelKey="register.lastName" path="lastName" inputCSS="form-control"
                                                mandatory="true" />
                    </div>

                    <div class="wrap-input100 validate-input">
                       <formElement:formInputBox idKey="register.email"
                                                labelKey="register.email" path="email" inputCSS="form-control"
                                                mandatory="true" />
                     </div>

                    <div class="wrap-input100 validate-input">
                        <formElement:formPasswordBox idKey="password" labelKey="register.pwd"
                                                    path="pwd" inputCSS="form-control password-strength" mandatory="true" />
                    </div>

                    <div class="wrap-input100 validate-input">
                        <formElement:formPasswordBox idKey="register.checkPwd"
                                                    labelKey="register.checkPwd" path="checkPwd" inputCSS="form-control"
                                                    mandatory="true" />
                    </div>

                    <spring:theme code="register.termsConditions" arguments="${getTermsAndConditionsUrl}" var="termsConditionsHtml" htmlEscape="false" />
                    <template:errorSpanField path="termsCheck">
                        <div class="checkbox">
                            <label class="labelTermsConditions">
                                <form:checkbox id="registerChkTermsConditions" path="termsCheck" disabled="false"/>
                                ${ycommerce:sanitizeHTML(termsConditionsHtml)}
                            </label>
                        </div>

                    </template:errorSpanField>

                    <ycommerce:testId code="register_Register_button">
                        <div class="container-login100-form-btn">
                            <button type="submit" class="login100-form-btn">
                                <spring:theme code='${actionNameKey}' />
                            </button>
                        </div>
                    </ycommerce:testId>



                </form:form>
            </div>
        </div>
</div>

<%--

<div class="user-register__headline">
	<spring:theme code="register.new.customer" />
</div>
<p>
	<spring:theme code="register.description" />
</p>

<form:form method="post" commandName="registerForm" action="${action}">
	<formElement:formSelectBox idKey="register.title"
		labelKey="register.title" selectCSSClass="form-control"
		path="titleCode" mandatory="true" skipBlank="false"
		skipBlankMessageKey="form.select.empty" items="${titles}" />
	<formElement:formInputBox idKey="register.firstName"
		labelKey="register.firstName" path="firstName" inputCSS="form-control"
		mandatory="true" />
	<formElement:formInputBox idKey="register.lastName"
		labelKey="register.lastName" path="lastName" inputCSS="form-control"
		mandatory="true" />
	<formElement:formInputBox idKey="register.email"
		labelKey="register.email" path="email" inputCSS="form-control"
		mandatory="true" />
	<formElement:formPasswordBox idKey="password" labelKey="register.pwd"
		path="pwd" inputCSS="form-control password-strength" mandatory="true" />
	<formElement:formPasswordBox idKey="register.checkPwd"
		labelKey="register.checkPwd" path="checkPwd" inputCSS="form-control"
		mandatory="true" />

    <c:if test="${ not empty consentTemplateData }">
        <form:hidden path="consentForm.consentTemplateId" value="${consentTemplateData.id}" />
        <form:hidden path="consentForm.consentTemplateVersion" value="${consentTemplateData.version}" />
        <div class="checkbox">
            <label class="control-label uncased">
                <form:checkbox path="consentForm.consentGiven" disabled="true"/>
                <c:out value="${consentTemplateData.description}" />

            </label>
        </div>
		<div class="help-block">
			<spring:theme code="registration.consent.link" />
		</div>

    </c:if>

	<spring:theme code="register.termsConditions" arguments="${getTermsAndConditionsUrl}" var="termsConditionsHtml" htmlEscape="false" />
	<template:errorSpanField path="termsCheck">
		<div class="checkbox">
			<label class="control-label uncased">
				<form:checkbox id="registerChkTermsConditions" path="termsCheck" disabled="false"/>
				${ycommerce:sanitizeHTML(termsConditionsHtml)}
			</label>
		</div>
	</template:errorSpanField>

	<input type="hidden" id="recaptchaChallangeAnswered"
		value="${fn:escapeXml(requestScope.recaptchaChallangeAnswered)}" />
	<div class="form_field-elements control-group js-recaptcha-captchaaddon"></div>
	<div class="form-actions clearfix">
		<ycommerce:testId code="register_Register_button">
			<button type="submit" class="btn btn-default btn-block">
				<spring:theme code='${actionNameKey}' />
			</button>
		</ycommerce:testId>
	</div>
</form:form>
--%>