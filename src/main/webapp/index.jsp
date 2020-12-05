<%@include file="head.jsp"%>
<html>

<body>
<div class="bgimg w3-display-container w3-text-white">
    <div class="w3-display-middle w3-jumbo">
        <p>Are you tired?</p>
        <p><button onclick="window.location.href='search.jsp';" class="w3-button w3-black">Search for a campsite</button></p>
    </div>
    <%@include file="top-buttons.jsp"%>
    <%@include file="bottom-buttons.jsp"%>
</div>

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
            <p>Created by Caroline and Bean</p>
        </div>
    </div>
</div>

</body>
</html>