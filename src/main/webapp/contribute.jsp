<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>
<%@include file="top-buttons-authenticated.jsp"%>

<div class="bgimg w3-display-container">
    <div class="w3-display-middle w3-large">
    <p>Share what you know about a campsite in Wisconsin to help other campers</p>
    <!--entry from that sends data back to employeeAdd-->
    <form action="addReview" method="POST">
        <!--select search type-->
        Add campsite info here:

            <label for="park">Park Name: </label>
            <input list="park" name="park" required="required">
            <datalist id="park">
                <option value="Amnicon Falls">
                <option value="Aztalan">
                <option value="Belmont Mound">
                <option value="Big Bay">
                <option value="Big Foot Beach">
                <option value="Blue Mound">
                <option value="Brunet Island">
                <option value="Buckhorn">
                <option value="Cambellsport Drumlins">
                <option value="Copper Falls">
                <option value="Council Grounds">
                <option value="Cross Plains">
                <option value="Devil's Lake">
                <option value="Grand Traverse Island">
                <option value="Governor Dodge">
                <option value="Governor Nelson">
                <option value="Governor Thompson">
                <option value="Harrington Beach">
                <option value="Hartman Creek">
                <option value="High Cliff">
                <option value="Interstate">
                <option value="Kohler-Andrae">
                <option value="Lake Kegonsa">
                <option value="Lake Wissota">
                <option value="Merrick">
                <option value="Mill Bluff">
                <option value="Mirror Lake">
                <option value="Natural Bridge">
                <option value="Nelson Dewey">
                <option value="New Glarus Woods">
                <option value="Newport">
                <option value="Pattison">
                <option value="Peninsula">
                <option value="Perrot">
                <option value="Potawatomi">
                <option value="Rib Mountain">
                <option value="Richard Bong">
                <option value="Roche-a-Cri">
                <option value="Rock Island">
                <option value="Rocky Arbor">
                <option value="Straight Lake">
                <option value="Tower Hill">
                <option value="Wildcat Mountain">
                <option value="Willow River">
                <option value="Wyalusing">
                <option value="Yellowstone Lake">
                <option value="Glaical Drumlin State Trail">
                <option value="Elroy-Sparta State Trail">
                <option value="Brule River State Forest">
                <option value="Black River State Forest">
                <option value="Flambeau River State Forest">
                <option value="Governor Knowles State Forest">
                <option value="Governor Earl Peshtigo State Forest">
                <option value="Kettle Moraine State Forest - North">
                <option value="Kettle Moraine State Forest - South">
                <option value="Kettle Moraine State Forest - Pike">
                <option value="Kettle Moraine State Forest - Lapham Peak">
            </datalist><br />
            <label for="siteno">Site Number: </label><input type="text" name="siteno" id="siteno" required="required"/><br />
            <label for="capacity">Site Hammock Capacity: </label><input type="number" name="capacity" id="capacity" required="required"/><br />
            <br />
            <!--submit button-->
            <input type="submit" name="" value="Submit" />
    </form>
    </div>
    <%@include file="about-modal.jsp"%>
    <%@include file="bottom-buttons.jsp"%>
</div>

</body>
</html>