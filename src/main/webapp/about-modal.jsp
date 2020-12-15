<%--
  Created by IntelliJ IDEA.
  User: caroline
  Date: 12/15/20
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- About Modal -->
<div id="about" class="w3-modal">
    <div class="w3-modal-content w3-animate-zoom">
        <!--<div class="w3-container w3-black w3-display-container">-->
        <div class="w3-container w3-black w3-display-container">
            <span onclick="document.getElementById('about').style.display='none'" class="w3-button w3-display-topright w3-large">x</span>
            <h1>This is the Hammocker Helper</h1>
        </div>
        <div class="w3-container">
            <p>This site helps people find campsites with two (or more!) trees that can support a hammock.
            <p>We currently have data for state parks and backcountry camp sites in the following places:<p>
            <ul><li>Wisconsin</li></ul>
            <p>When you sing up for a username, you can add information about campsites you've visited
                (whether hammock friendly or not) and review what others have submitted to help us make sure
                what we have is accurate.</p>
            <p>Created by Caroline and Bean (the cat) for Mad Java at Madison Area Technical College</p>
        </div>
    </div>
</div>