<%@include file="head.jsp"%>
<html>
<title>You look like you could use a good night's sleep.</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>
    body,h1,h5 {font-family: "Raleway", sans-serif}
    body, html {height: 100%}
    .bgimg {
        background-image: url('BackgroundImage.jpg');
        min-height: 100%;
        background-position: center;
        background-size: cover;
    }
</style>
<body>
<div class="bgimg w3-display-container w3-text-white">
    <div class="w3-display-middle w3-jumbo">
        <p>Are you tired?</p>
        <p><button onclick="window.location.href='search.jsp';" class="w3-button w3-black">Search for a campsite</button></p>
    </div>
    <div class="w3-display-topleft w3-container w3-xlarge">
        <p><button onclick="window.location.href='authenticatedhome.jsp';" class="w3-button w3-black">Log in</button></p>
        <p><button onclick="window.location.href='signup.jsp';" class="w3-button w3-black">Sign up</button></p>
    </div>
    <div class="w3-display-bottomleft w3-container">
        <p><button onclick="window.location.href='contribute.jsp';" class="w3-button w3-black">Contribute to the database</button></p>
        <p><button onclick="document.getElementById('about').style.display='block'" class="w3-button w3-black">about</button></p>
        <p>CSS by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
        <p>Image from <a href="https://freeartbackgrounds.com" target="_blank">free art backgrounds</a></p>
    </div>
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