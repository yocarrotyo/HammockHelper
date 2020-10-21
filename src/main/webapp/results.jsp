<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="head.jsp"%>

<html><body>

<div class="container-fluid">
    <h2>Search Results: </h2>
    <h3>The following users matched your search:</h3>
    <table>
        <tr><td>First Name</td><td>Last Name</td><td>Username</td></tr>
        <!--loop through the employees in the list-->
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.fname}</td>
                <td>${user.lname}</td>
                <td>${user.username}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
