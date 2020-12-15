<%--
  Created by IntelliJ IDEA.
  User: caroline
  Date: 12/9/20
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="head.jsp"%>
<body>
<%@include file="top-buttons-authenticated.jsp"%>
<div class="bgimg w3-display-container">
    <div class="w3-display-middle w3-large">
        <p>Hello! Thanks for reviewing campsite data for accuracy. You can review information about park at a time.</p>
        <form action="findForReview" method="GET">
            <!--select search type-->
            <label for="park">Choose a park you're familiar with:</label>
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
            <!--submit button-->
            <input type="submit" name="" value="Get data to review" />
        </form>
    </div>
    <%@include file="bottom-buttons.jsp"%>
    <%@include file="about-modal.jsp"%>
</div>

</body>
</html>
