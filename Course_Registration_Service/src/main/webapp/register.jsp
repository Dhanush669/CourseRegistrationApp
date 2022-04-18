<!DOCTYPE html>
<html>
        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>
                    Register Account
                </title>
                <style>
                    body{
                        margin: 0;
                        position: absolute;
                        top: 50%;
                        left: 50%;
                        -ms-transform: translate(-50%, -50%);
                        transform: translate(-50%, -50%);
                    }
                    *{
                      margin: 0;
                      padding: 0;
                      font-family:sans-serif;
                  }
                .login-container {
                    margin: 0 auto;
                    width: 100%;
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
                    height: 70vh;
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
                  #login{
                      margin-top: 40px;
                  }
                  form{
                    width: 80%;
                    /* height: 50px; */
                    margin-top: 20px;
                    display: grid;
                    grid-template-columns: auto auto; 
                    
                  }

                  input{
                        height: 2rem;
                        width: 95%;
                        padding: 5px;
                        font-size: 14px;
                        
                  }
                  
                  .input-div{
                      margin-left: 10px;
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
                      margin-left: 12px;
                      grid-column-start: 1;
                      grid-column-end: 3;
                      margin-right: 200px;
                      
                  }
                  
                  #error{
                      color: red;
                      font-size: 14px;
                      margin-bottom: 1.5rem;
                      display: none;
                  }
                  
                  #exception{
                      margin-top: 10px;
                      color:red;
                      font-size: 14px;
                  }

                </style>
                
                <script th:src="@{/webjars/jquery/jquery.min.js}"></script>
                <script th:src="@{/webjars/popper.js/umd/popper.min.js}"></script>
                <script th:src="@{/webjars/bootstrap/js/bootstrap.min.js}"></script>
                <script th:src="@{/assets/izitoast/js/iziToast.min.js}"></script>
                
                
                
            </head>

            <body>
                <div class="login-container">
                    <div class="logo-div">

                    </div>
                    <h5>Create a new account</h5>
                        <form name="myForm" action="/registrationdone" onsubmit="return validate()" method="post">
<!--                            <p id="form-heading">Personal Details</p>-->
                            <div class="input-div">
                                <label id="lable" for="fname">First Name</label>
                                
                                <input type="text" id="fname" name="fname" value="" required placeholder="First Name" 
                                       oninvalid="this.setCustomValidity('First Name should not be empty!')"
                                        oninput="this.setCustomValidity('');removeException()"
                                        
                                        >
<!--                                <p id="error" class="efname">First Name should not be empty!</p>-->
                            </div>
                            <div class="input-div">
                                <label id="lable" for="lname">Last Name</label>
                                
                                <input type="text" id="lname" name="lname" value=""
                                       required placeholder="Last Name" 
                                       oninvalid="this.setCustomValidity('Last Name should not be empty!')"
                                        oninput="this.setCustomValidity('');removeException()"
                                       >
<!--                                <p id="error" class="elname">Last Name should not be empty!</p>-->
                            </div>
                            <div class="input-div">
                                <label id="lable" for="phno">Phone Number</label>
                                
                                <input type="text" id="phno" name="phno" value=""
                                       required placeholder="9876564743" 
                                       oninvalid="this.setCustomValidity('Phone Number should not be empty!')"
                                        oninput="this.setCustomValidity('');removeException()"
                                       >
<!--                                <p id="error" class="ephno">Phone Number should not be empty!</p>-->
                            </div>
                            
<!--                            <p id="form-heading">Personal Details</p>-->
                            
                            <div class="input-div">
                                <label id="lable" for="userName">Email</label>
                                
                                <input type="email" id="mailid" name="mailid" value=""
                                       required placeholder="abc@gmail.com" 
                                       oninvalid="this.setCustomValidity('Enter a valid email!')"
                                        oninput="this.setCustomValidity('');removeException()"
                                       >
<!--                                <p id="error" class="eemail">Email should not be empty!</p>-->
                            </div>
                            
                            <div class="input-div">
                                <label id="lable" for="password">Password</label>
                                
                                <input type="password" id="password" name="password" value=""
                                       required placeholder="password" 
                                       oninvalid="this.setCustomValidity('Password should not be empty!')"
                                        oninput="this.setCustomValidity('');removeException()"
                                       >
<!--                                <p id="error" class="epassword">Password should not be empty!</p>-->
                            </div>
                            
                            <div class="input-div">
                                <label id="lable" for="confirmpassword">Confirm Password</label>
                                
                                <input type="password" id="confirmpassword" name="confirmpassword" value=""
                                       required placeholder="confirm password" 
                                       oninvalid="this.setCustomValidity('Confirm Password should not be empty!')"
                                        oninput="this.setCustomValidity('');removeException()"
                                       >
<!--                                <p id="error" class="econfirmpassword">Confirm Password should not be empty!</p>-->
                            </div>
                            
                            <input id="submit" type="submit" value="Register" style="">
                        </form>
                    
                    <p id="login">already have an account? <a href="/authenticate">login</a></p>
                    <p id="exception">${exception}</p>
                </div>
                
                <script>
                    function validate() {
                      let fname = document.forms["myForm"]["fname"].value;
                      var pass=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,100}$/;
//                      let lname = document.forms["myForm"]["lname"].value;
                      let phno = document.forms["myForm"]["phno"].value;
                      let password = document.forms["myForm"]["password"].value;
                      let confirmPassword = document.forms["myForm"]["confirmpassword"].value;
//                      let email = document.forms["myForm"]["mailid"].value;
//                      if (fname =="") {
//                        document.getElementByClassName("efname").style.visibility="visible";
//                        return false;
//                      }
                        //let x = document.forms["myForm"]["fname"].value;
                        if (phno.length!==10) {
                          alert("enter a valid phone number");
                          return false;
                        }
                        if(!password.match(pass)){
                            alert("password should contain\n  -atleast 8 characters.\n  -atleast 1 upper case.\n  -atleast 1 lower case.\n  -atleast 1 special character.\n  -atleast 1 numeric value.")
                            return false;
                        }
                        if(password!==confirmPassword){
                            alert("password doesn't match!");
                            
                            return false;
                        
                    }
                }
                    function removeException(){
                        document.getElementById("exception").innerHTML="";
                    }
                </script>
                
            </body>

</html>