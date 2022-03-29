<!DOCTYPE html>
<head>
    <title>
        Home Page
    </title>

    <style>

        .topnav button {
        float: right;
        color: #000000;
        text-align: center;
        padding: 14px 16px;
        font-size: 16px;
        }

    </style>

</head>
<html>
    <body>
        ${name.getAttribute()}
        <div class="topnav">
            <b>course title</b>
            <button onclick="location.href='/userlogin'">LogIn</button>
            <button onclick="location.href='/register'">Register</button>
            <button onclick="location.href='/showdetails'">Show Details</button>
        </div>
    </body>
</html>