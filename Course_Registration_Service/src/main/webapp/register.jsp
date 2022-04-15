<!DOCTYPE html>
<html><head>
    <title>Courses</title>
    <style>
        .center {
    margin: auto;
    width: 30%;
    /* position: absolute; */
    background-color: rgba(211, 211, 211, 0.301);
    padding: 20px;
    font-size: 18px;
    /* text-align: center; */
   
  }
        </style>
        <!-- <spring:url value="src/main/resources/static/css/register.css" var="css" />
        <link href="${css}" rel="stylesheet" /> -->
</head>

<body data-new-gr-c-s-check-loaded="14.1052.0" data-gr-ext-installed="">
<!--    <script src="main/Web Pages/javascript/script_registrations.js"></script>-->
    <h1 style="text-align: center;">User registration</h1>
    <div class="center">
        <span style="align-content: center;">
            <form action="/registrationdone" method="post">
                <label for="fname" style="font-size: 16px;">First Name:</label><br>
                <input style="height: 1.5rem;width: 60%;" type="text" id="fname" name="fname" value=""><br><br>
                <label for="lname" style="font-size: 16px;">Last Name:</label><br>
                <input type="text" id="lname" name="lname" value="" style="height: 1.5rem;width: 60%;"><br><br>
                <label for="phno" style="font-size: 16px;">Phone Number:</label><br>
                <input type="text" id="phno" name="phno" value="" style="height: 1.5rem;width: 60%;"><br><br>
                <label for="mailid" style="font-size: 16px;">Email ID:</label><br>
                <input type="email" id="mailid" name="mailid" value="" style="height: 1.5rem;width: 60%;"><br><br>
                <label for="password" style="font-size: 16px;">Password:</label><br>
                <input type="password" id="password" name="password" value="" style="height: 1.5rem;width: 60%;"><br><br>
                <label for="confirmpassword" style="font-size: 16px;">Confirm Password:</label><br>
                <input type="password" id="confirmpassword" name="confirmpassword" value="" style="height: 1.5rem;width: 60%;"><br><br>
                <input type="submit" value="Submit" style="width: 20%;align-items: center;">
              </form>
        </span>
    </div>
</body>
</html>