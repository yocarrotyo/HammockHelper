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
<div class="bgimg w3-display-container w3-text-black">
    <div class="w3-display-middle w3-jumbo">
        <p>Hammocker Helper</p>
    </div>
    <div class="w3-display-topleft w3-container w3-xlarge">
        <p><button onclick="window.location.href='login.jsp';" class="w3-button w3-black">Log in</button></p>
        <p><button onclick="window.location.href='signup.jsp';" class="w3-button w3-black">Sign up</button></p>
    </div>
    <div class="w3-display-bottomleft w3-container">
        <p class="w3-xlarge">Your source for finding hammock-friendly campsites in Wisconsin</p>
        <p class="w3-large">Created by Caroline and Bean (who is a cat)</p>
        <p>powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    </div>
</div>
</body>
</html>