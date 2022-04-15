<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>
            LogIn
        </title>
        <style>
            *{
              margin: 0;
              padding: 0;
          }
        .login-container {
            margin: 0 auto;
            width: 30%;
            background-color: rgba(211, 211, 211, 0.301);
            padding: 20px;
            font-size: 18px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            height: 500px;
          }
          
          .logo-div{
              width: 80px;
              height: 80px;
              background-color: black;
              margin-bottom: 20px;
          }
          h2{
              margin-bottom: 10px;
          }
          p{
              margin-top: 40px;
          }
          form{
            width: 80%;
            /* height: 50px; */
            margin-top: 20px;
            
          }
          
          input{
                height: 2.5rem;
                width: 100%;
                padding: 5px;
                font-size: 16px;
          }
          
          lable{
              font-size: 20px;
          }
          
        </style>
    </head>

    <body>
        <div class="login-container">
            <div class="logo-div">
                
            </div>
            <h2>Sign In with your account</h2>
                <form action="/userlogin" method="post">
                    <label for="userName">Email Id:</label><br>
                    <input type="email" id="userName" name="userName" value=""><br><br>
                    <label for="password">Password:</label><br>
                    <input type="password" id="password" name="password" value=""><br><br>
                    <input type="submit" value="LogIn" style="width: 100%; height: 50px; padding:0">
                  </form>
            <p>don't have an account? <a href="/register">register</a></p>
        </div>
    </body>

</html>