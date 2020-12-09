<%--
  Created by IntelliJ IDEA.
  User: caroline
  Date: 11/30/20
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<%@include file="top-buttons.jsp"%>
<body>
<div class="bgimg w3-display-container w3-text-white">
    <div class="w3-display-middle w3-large">
    Welcome to the campsite search!
    Search for a park to find out which campsites have good trees to hang a hammock.
    <form action="searchCampsite" method="GET">
        <!--select search type-->
        <label for="park">Start typing the name of a park:</label>
        <input list="park" name="park">
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
            </datalist>
        <br />
        You can also check a specific campsite at this park to find out if it's hammock-friendly or not.
        <br />
        <label for="siteno">What's the site number?</label><input type="text" id="siteno" name="siteno"><br>

        <br />
        <!--submit button-->
        <input type="submit" name="" value="Find me some trees" />
    </form>
    </div>
</div>
<%@include file="bottom-buttons.jsp"%>
</body>
</html>
