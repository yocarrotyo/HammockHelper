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

            <label for="siteparkname">Park Name: </label><input type="text" name="siteparkname" id="siteparkname" value="siteparkname" required="required"/><br />
            <label for="siteno">Site Number: </label><input type="text" name="siteno" id="siteno" value="siteno" required="required"/><br />
            <label for="sitecap">Site Hammock Capacity: </label><input type="text" name="ssn" id="sitecap" value="sitecap" required="required"/><br />
            <br />
            <!--submit button-->
            <input type="submit" name="" value="Enter" />
    </form>
</div>
</body>
</html>