<!DOCTYPE html>
<head>
    <title>
        Home Page
    </title>

    <style>
        *{
            text-decoration: none;
            font-family: sans-serif;
            margin: 0;
            padding: 0;
        }

        .topnav{
            
/*        float: right;
        color: #000000;
        text-align: center;
        padding: 14px 16px;
        font-size: 16px;*/
        display:flex;
        justify-content: space-between;
        background-color: black;
        padding: 10px;
        align-items: center;
         
        }
        
        a{
            margin: 20px;
            color: white;
        }
        b{
            color: white;
            font-size: 2em;
            margin-left: 5px
        }

    </style>
    <link rel="stylesheet" type="text/css" href='${path}/css/register.css'/>
</head>
<html>
    <body>
        <div class="topnav">
            <div>
                <img src="${path}/src/main/resources/static/asserts/logo.png" />
                <b>Course</b>
            </div>
            <div>
                <a href="/courses">
                    Courses
                </a>
                <a href="/authenticate">
                    LogIn
                </a>
                <a href="/register">
                    Register
                </a>
                
            </div>
        </div>
    </body>
</html>