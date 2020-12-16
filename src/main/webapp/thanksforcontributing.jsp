<%--
  Created by IntelliJ IDEA.
  User: caroline
  Date: 12/8/20
  Time: 6:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>

<body>

<div class="bgimg w3-display-container">
    <%@include file="top-buttons-authenticated.jsp"%>
    <div class="w3-display-middle w3-large">
        <p>Thanks for contributing to Hammock Helper!</p>
        <p>We add all submitted data to a provisional table for review by other users, so everyone contributes to the data's acccuracy.</p>
        <p>After at least two people have agreed that the data about a specific campsite is accurate, it's copied into our
            campsite database so that others can find it with the search. You can help any time by visiting the Review Data page.</p>
        <p>Happy Hammocking!</p>
    </div>
    <%@include file="bottom-buttons.jsp"%>
    <%@include file="about-modal.jsp"%>
</div>


</body>
</html>
