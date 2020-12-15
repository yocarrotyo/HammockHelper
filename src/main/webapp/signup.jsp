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
<body>
<div class="bgimg w3-display-container">
    <div class="w3-display-middle w3-large">
        <p>Hello! Glad you decided to join the Hammock Helper community of campers.</p>
        <p>Choose a username and password for yourself and submit an email address if you'd like.</p>
        <form id="signUpForm" role="form" data-toggle="validator" class="form-horizontal"
              action="signUpUser"
              method="post">

            <div class="form-group">
                <label class="control-label col-sm-2" for="fname">First
                    Name</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="fname"
                           name="fname"
                           data-error="Please enter your first name." required>
                </div>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="lname">Last Name</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="lname"
                           name="lname"
                           data-error="Please enter your last name." required>
                </div>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label  class="control-label col-sm-2" for="email">Email
                    Address</label>
                <div class="col-sm-4">
                    <input type="email" class="form-control" id="email"
                           name="email"
                           data-error="Please enter your email address." required>
                </div>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label  class="control-label col-sm-2" for="username">Username</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="username"
                           name="username"
                           data-error="Please enter a username." required>
                </div>
                <div class="help-block with-errors"></div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="password">Password
                </label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="password"
                           name="password" data-error="Please provide a password."
                           required>
                    <div class="help-block with-errors"></div>
                </div>

            </div>
            <div class="form-group">
                <label class="control-label col-sm-2"
                       for="confirmPassword">Retype
                    Password</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" id="confirmPassword"
                           name="confirmPassword" equalTo="#password"
                           data-match="#password"
                           data-match-error="Confirmation password does not match"
                           required data-error="Please retype your password.">
                    <div class="help-block with-errors"></div>
                </div>
            </div>

            <button type="submit" class="btn btn-default col-sm-offset-3"
                    data-disable="true">Submit
            </button>
            <button type="reset" class="btn btn-default">Clear</button>
            <!--for google recaptcha. Not figureing this out....-->
            <!--<div class="g-recaptcha" data-sitekey="6LewtTgUAAAAADuEbgusz9FbghpuXq-gBm6rLPS9"></div>-->
        </form>
    </div>
</div>
</body>
</html>

</form>
</html>
