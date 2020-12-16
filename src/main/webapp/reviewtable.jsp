<%--
  Created by IntelliJ IDEA.
  User: caroline
  Date: 12/9/20
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@include file="head.jsp"%>
<body>
    <div class="bgimg w3-display-container">
        <%@include file="top-buttons-authenticated.jsp"%>
        <div class="w3-display-middle w3-large">

        <c:choose>
            <c:when test="${not empty siteerror}">
                ${siteerror}
            </c:when>
            <c:otherwise>
                <p>Below is a table with all the campsite data we have collected for the park you specified.</p>
                <p>Note that there might be duplicates, and that's okay. When we know which information is more likely to be correct, we'll delete the incorrect duplicates.</p>
                <p>Review the campsite data shown. If you see a hammock capacity that you know is incorrect, update the value and check the box in the "Dispute" column.</p>
                <p>If you see a hammock capacity that you know is correct, check the box in the Affirm column so we know more than one person agrees with this information.</p>
                <p>Don't change the capacity or check the boxes for sites that you're not sure about.</p>
                <form action="processReview" method="POST">
                <!--select search type-->
                    <table>
                    <tr><td>Site number</td><td>Dispute?</td><td>Affirm?</td><td>Capacity</td></tr>
                        <c:forEach var="site" items="${siteList}">
                        <tr>
                        <td>${site.siteno}</td>
                        <td><input type="checkbox" id=dispute${site.siteno} name=dispute${site.siteno} value=dispute${site.siteno} /></td>
                        <td><input type="checkbox" id=affirm${site.siteno} name=affirm${site.siteno} value=affirm${site.siteno} /></td>
                        <td><input type="text" id=hamcap${site.siteno} name=hamcap${site.siteno} value=${site.capacity} /></td>
                        </tr>
                        </c:forEach>
                    </table>
                    <!--submit button-->
                    <input type="submit" name="" value="Submit" />
                </form>
            </c:otherwise>
        </c:choose>
        </div>
        <%@include file="about-modal.jsp"%>
        <%@include file="bottom-buttons.jsp"%>
    </div>

</body>
</html>
