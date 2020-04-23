<html>
<head>
<style>
/* Container */
.container{
	
    width:35%;
    margin:0 auto;
}

/* Login */
#div_login{
    border: 1px solid gray;
    border-radius: 3px;
    width: 470px;
    height: 270px;
    box-shadow: 0px 2px 2px 0px  gray;
    margin: 0 auto;
}




#div_login div{
    clear: both;
    margin-top: 10px;
    padding: 5px;
}

#div_login .textbox{
    width: 50%;
    padding: 7px;
}

#div_login input[type=submit]{
    padding: 7px;
    width: 100px;
    background-color: lightseagreen;
    border: 0px;
    color: white;
}
</style>
</head>
<body>
<div class="container">
    <form method="post" action="">
        <div id="div_login">
            <center><h1>Login Form</h1>
            <div>
                <input type="text" class="textbox" id="txt_uname" name="txt_uname" placeholder="Username" />
            </div>
            <div>
                <input type="password" class="textbox" id="txt_uname" name="txt_pwd" placeholder="Password"/>
            </div>
			
            <div>
                <input type="submit" value="Submit" name="but_submit" id="but_submit" />
            
			
				<input type="checkbox" class="checkbox" > Remember me
			</div>
			</center>
			
        </div>
    </form>
</div>
</body>
</html>