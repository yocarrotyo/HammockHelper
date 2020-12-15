<%--
  Created by IntelliJ IDEA.
  User: caroline
  Date: 10/21/20
  Time: 1:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="head.jsp"%>
<html>
<jsp:include page="head.jsp" />
<body>
    <div class="bgimg w3-display-container">
        <div class="w3-display-middle w3-large">
            <FORM ACTION="j_security_check" METHOD="POST">
                <TABLE>
                    <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
                    <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
                    <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
                </TABLE>
            </FORM>
        </div>
    </div>
</body>

</html>
