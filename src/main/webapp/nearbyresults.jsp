<%--
  Created by IntelliJ IDEA.
  User: caroline
  Date: 12/3/20
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>

yo this is the nearby results page what's up, the park is
<p>parkid (original session attr): ${parkid}</p>
<p>parkid1 (retrieved and re-set session attr): ${parkid1}</p>
<p>parkid2 (send via the form): ${parkid2}</p>
<ul>
    <c:forEach var="zip" items="${nearbyZIPS}">
        <li>${zip}</li>
    </c:forEach>
</ul>
</body>
</html>
