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
              font-family:sans-serif;
          }
          body{
                margin: 0;
                position: absolute;
                top: 50%;
                left: 50%;
                -ms-transform: translate(-50%, -50%);
                transform: translate(-50%, -50%);
            }
        .login-container {
            margin: 0 auto;
            width: 70%;
            background-color: rgba(211, 211, 211, 0.301);
            padding: 20px;
            font-size: 18px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            height: 500px;
            border-radius: 1rem;
            margin-top: 20px;
          }
          
          .logo-div{
              width: 80px;
              height: 80px;
              background-color: black;
              margin-bottom: 20px;
          }
          h5{
              margin-bottom: 10px;
              font-size: 1.3em;
              
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
                height: 2rem;
                width: 100%;
                padding: 5px;
                font-size: 16px;
                margin-bottom: 1.5rem;
          }
          
          #lable{
              font-size: 14px;
              font-weight: bold;
          }
          
          #submit{
              width: 100%; 
              height: 50px; 
              padding:0;
              color: white;
              font-weight: bold;
              background-color: green;
              border: none;
              margin: 0 auto;
              margin-left: 7px;
          }
          
        #exception{
            margin-top: 10px;
            color:red;
            font-size: 14px;
        }
          
        </style>
            
        <script>
//            function validate(){
//                let email=document.forms["myForm"]["userName"].value;
//                let password=document.forms["myForm"]["password"].value;
//                if(email)
          //  }
        function removeException(){
            document.getElementById("exception").innerHTML="";
        }
        </script>    
    </head>

    <body>
        <div class="login-container">
            <div class="logo-div">
                
            </div>
            <h5>Sign In with your account</h5>
                <form name="myForm" action="/userlogin" method="post">
                    <label id="lable" for="userName">Email</label>
                    <input type="email" id="userName" name="userName" value=""
                           required placeholder="email" 
                            oninvalid="this.setCustomValidity('Enter a valid email')"
                             oninput="this.setCustomValidity('');removeException()"
                           >
                    <label id="lable" for="password">Password</label>
                    <input type="password" id="password" name="password" value=""
                           required placeholder="password" 
                                oninvalid="this.setCustomValidity('password should not be empty!')"
                                 oninput="this.setCustomValidity('');removeException()"
                           >
                    <input id="submit" type="submit" value="LogIn" style="">
                </form>
            <p>don't have an account? <a href="/register">register</a></p>
            <p id="exception">${exception}</p>
        </div>
    </body>

</html>