<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./styles/login.css">
    <link rel="stylesheet" href="./styles/main.css">

</head>
<title>Admin Login</title>

<body>

<div class="container">
    <h2>Admin Login</h2>
    <form method="post" action="<%= request.getContextPath() %>/adminVerificationServlet" name="login-form" id="login-form" >
        <div class="input-div">
            <label for="adminID">Admin ID</label>
            <input type="text" name="adminID" id="adminID">
        </div>

        <div class="input-div">
            <label for="password">Password</label>
            <input id="password" name="password" type="password">
        </div>

        <div class="submitions">
            <input type="submit" value="Login">
        </div>


    </form>
</div>
<script src="login.js"></script>

</body>

</html>