<%--
  Created by IntelliJ IDEA.
  User: caroline
  Date: 10/21/20
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp" />
<body>
<div class="bgimg w3-display-container">
    <div class="w3-display-middle w3-large">
        <p>Those login credentials weren't correct.</p>
        <a href="login.jsp"><button type="button" class="w3-button w3-black">
            Retry</button></a>
        <button onclick="window.location.href='search.jsp';" class="w3-button w3-black">Search as a guest</button>
</body>
</html>
