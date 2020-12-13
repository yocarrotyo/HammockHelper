<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="head.jsp"%>
<body>

<div class="bgimg w3-display-container w3-text-white">
    <%@include file="top-buttons.jsp"%>
    <div class="w3-display-middle w3-large">

        <c:set var="campsitescol" value="${campsites}"></c:set>
        <c:set var="parkerror" value="${parkerror}"></c:set>

            <!--park results. ether there is a park error, or we found some campsites, or we found the park but no campsites-->
            <c:choose>
                <c:when test="${not empty parkerror}">
                    ${parkerror}
                </c:when>
                <c:when test="${not empty campsitescol}">
                    <p>Here are all the hammock-friendly campsites we found at ${park}</p>
                    <table class="w3-table">
                        <tr><td>Campsite #</td><td>Number of hammocks</td></tr>
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
                    Try searching for sites at parks within 20 miles of ${park} by clicking the "Find nearby" button below.
                </c:otherwise>
            </c:choose>

            <!--specific campsite results if available-->
            <c:set var="isFriendly" value="${isFriendly}"></c:set>
            <c:set var="siteno" value="${siteno}"></c:set>
            <c:set var="siteerror" value="${siteerror}"></c:set>
            <c:if test="${not empty siteno}">
                <c:choose>
                    <c:when test="${not empty siteerror}">
                        ${siteerror}
                    </c:when>
                    <c:when test="${isFriendly=='yes'}">
                        <p> The site you looked up, ${siteno}, is hammock-friendly!</p>
                    </c:when>
                    <c:when test="${isFriendly=='no'}">
                        <p> The site you looked up, ${siteno}, is not hammock-friendly. Try one of the others at this park or pack a tent.</p>
                    </c:when>
                </c:choose>
            </c:if>
        <br>
        <br>
        <button onclick="window.location.href='search.jsp';" class="w3-button w3-black">Search again</button>
        <form action="findNearby" method="GET"><input type="submit" name="" class="w3-button w3-black" value="Find nearby" /></form>
    </div>

</div>

<%@include file="bottom-buttons.jsp"%>
</body>
</html>
