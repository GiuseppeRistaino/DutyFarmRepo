<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>


<footer>
    <%-- <hr class="hr-footer"> --%>

    <cms:pageSlot position="Footer" var="feature" element="div" class="footerSlot">
        <cms:component component="${feature}" element="div" class="footerComponent"/>
    </cms:pageSlot>


</footer>

