<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="head.jsp"%>
<body>

<div class="bgimg w3-display-container w3-text-white">
    <div class="w3-display-middle w3-large">
    <c:set var="campsitescol" value="${campsites}"></c:set>

        <c:choose>
            <c:when test="${not empty campsitescol}">
                <p>Here are all the hammock-friendly campsites we found at ${park}<p>
                <table class="w3-table">
                    <tr><td>Campsite #</td><td>Number of hammocks</td>
                        <!--loop through the employees in the list-->
                        <c:forEach var="site" items="${campsites}">
                    <tr>
                        <td>${site.siteno}</td>
                        <td>${site.capacity}</td>
                    </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                Sadly we do not know of any hammock-friendly campsites at ${park}.
                Try searching for sites at parks within 40 miles of ${park} by clicking the "Find nearby" button below.
            </c:otherwise>
        </c:choose>


        <c:set var="isFriendly" value="${isFriendly}"></c:set>
    <c:set var="siteno" value="${siteno}"></c:set>
    <c:if test="${not empty siteno}">
        <c:if test="${isFriendly=='yes'}">
            <p> The site ${siteno} is Hammock-friendly: ${isFriendly}</p>
        </c:if>
        <c:if test="${isFriendly=='no'}">
            <p> The site ${siteno} is not Hammock-friendly :( : ${isFriendly}</p>
        </c:if>
    </c:if>
    <p>The siteno is: ${siteno}</p>


    </div>
    <div class="w3-display-bottommiddle">
        <button onclick="window.location.href='search.jsp';" class="w3-button w3-black">Search again</button>
        <form action="findNearby" method="GET"><input type="submit" name="" class="w3-button w3-black" value="Find nearby" /></form>
        <button onclick="window.location.href='contribute.jsp';" class="w3-button w3-black">Contribute data</button>

    </div>
</div>
</body>
</html>
