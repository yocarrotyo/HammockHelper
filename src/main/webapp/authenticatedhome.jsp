<%--
  Created by IntelliJ IDEA.
  User: caroline
  Date: 11/30/20
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>
<div class="bgimg w3-display-container w3-text-white">
    <div class="w3-display-middle w3-large">
        <p>Hello! What would you like to do now?</p>
        <p>You can add to the database of hammock-friendly campsites, or help ensure our information is up-to-date
            and accurate by reviewing info that was submitted by other people.</p>
        <p><button onclick="window.location.href='contribute.jsp';" class="w3-button w3-black">Add a new site</button></p>
        <p><button onclick="window.location.href='startreview.jsp';" class="w3-button w3-black">Review data</button></p>

    </div>
</div>
</body>
</html>
