<!DOCTYPE html>
<html>

    <head>
        <title>
            LogIn
        </title>
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
    </head>

    <body>
        <div class="center">
            <span>
                
                    <form action="/home">
                        <label for="email" style="font-size: 16px;">Email Id:</label><br>
                        <input style="height: 1.5rem;width: 80%;" type="email" id="email" name="email" value=""><br><br>
                        <label for="password" style="font-size: 16px;">Password:</label><br>
                        <input type="password" id="password" name="password" value="" style="height: 1.5rem;width: 80%;"><br><br>
                        <input type="submit" value="LogIn" style="width: 20%;">
                      </form>
                
            </span>
        </div>
    </body>

</html>