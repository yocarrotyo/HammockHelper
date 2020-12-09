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

<p>Thanks for contributing to Hammock Helper!</p>
<p>Here are the details of the site you added: </p>
<table class="w3-table">
    <tr><td>Park</td><td>Campsite #</td><td>Number of hammocks</td></tr>
    <tr><td>${thePark.parkname}</td><td>${addedSite.siteno}</td><td>${addedSite.capacity}</td></tr>
</table>
<div class="w3-display-bottommiddle">
    <button onclick="window.location.href='contribute.jsp';" class="w3-button w3-black">Add Another Site</button>
    <button onclick="window.location.href='search.jsp';" class="w3-button w3-black">Back to the Search</button>
</div>
</body>
</html>
