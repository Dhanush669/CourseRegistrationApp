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
        <!-- WELCOME ${name.getFname()} ${name.getLname()} -->
        <div class="topnav">
            <b>course title</b>
            <button onclick="location.href='/userlogin'">LogIn</button>
            <button onclick="location.href='/create'">Register</button>
            <button onclick="location.href='/showdetails'">Show Details</button>
        </div>
    </body>
</html>