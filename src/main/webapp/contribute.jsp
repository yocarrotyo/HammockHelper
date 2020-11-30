<%@include file="head.jsp"%>
<html>
<body>

<h2>Here is where you add site data to the Helper</h2>
<p>This page can only be seen by registered campers.</p>
<div class="content">
    <h4>Employee Add Form</h4>
    <!--entry from that sends data back to employeeAdd-->
    <form action="addReview" method="POST">
        <!--select search type-->
        Add campsite info here:

            <label for="siteparkname">Park Name: </label><input type="text" name="siteparkname"/><br />
            <label for="siteno">Site Number: </label><input type="text" name="siteno"/><br />
            <label for="sitecap">Site Hammock Capacity: </label><input type="text" name="ssn" value="sitecap"/><br />
            <br />
            <!--submit button-->
            <input type="submit" name="" value="Enter" />
    </form>
    <!-- display a message if there is one-->
    <c:if test="${addMsg != null}" >
        <h3>Result: ${addMsg} </h3>
    </c:if>
</div>
</body>
</html>