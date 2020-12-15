<%--
  Created by IntelliJ IDEA.
  User: caroline
  Date: 12/8/20
  Time: 9:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="head.jsp"%>
<body>
    <div class="bgimg w3-display-container">
        <div class="w3-display-middle w3-large">
        <c:choose>
            <c:when test = "${errorMessage == null}">

                    <p><strong>New User Registration -- Success</strong> You can now log in with your new username and password and start sharing your campsite knowledge!</p>
                    <p><button onclick="window.location.href='contribute.jsp';" class="w3-button w3-black">Log in to contribute</button></p>

            </c:when>
            <c:otherwise>

                    <strong>New User registration failed:</strong>${errorMessage}<br />
                    <br /><br />
                    <a href="signup.jsp"><button type="button" class="btn btn-primary">
                        Retry</button></a>
                    <button onclick="window.location.href='search.jsp';" class="w3-button w3-black">Search as a guest</button>

            </c:otherwise>
        </c:choose>
        </div>
        <jsp:include page="bottom-buttons.jsp" />
        <jsp:include page="about-modal.jsp" />
    </div>
</body>

</html>