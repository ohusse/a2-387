<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/login.css">
    <link rel="stylesheet" href="styles/main.css">
</head>
<title>Student Login</title>

<body>

<div class="container">
    <h2>Student Login</h2>

    <form method="post" action="<%= request.getContextPath() %>/StudentVerificationServlet" name="login-form" id="login-form" >
        <div class="input-div">
            <label for="studentID">Student ID</label>
            <input type="text" name="studentID" id="studentID" >
        </div>

        <div class="input-div">
            <label for="password">Password</label>
            <input type="password" name="password" id="password">
        </div>

        <div class="submitions">
            <input type="submit" value="Login">
        </div>


    </form>
</div>
<script src="login.js"></script>
</body>

</html>