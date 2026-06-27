<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shoe Store Login</title>

<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',sans-serif;
}

body{
    display:flex;
    justify-content:center;
    align-items:center;
    min-height:100vh;
    background:linear-gradient(
    135deg,
    #0f172a,
    #1e293b,
    #2563eb);
}

.wrapper{

    width:420px;

    background:rgba(255,255,255,0.08);

    border:2px solid rgba(255,255,255,0.2);

    backdrop-filter:blur(15px);

    color:white;

    border-radius:15px;

    padding:35px 40px;

    box-shadow:0 10px 25px rgba(0,0,0,0.3);
}

.wrapper h1{
    text-align:center;
    font-size:34px;
    margin-bottom:25px;
}

.logo{
    text-align:center;
    font-size:50px;
    margin-bottom:10px;
}

.input-box{
    position:relative;
    width:100%;
    height:55px;
    margin:20px 0;
}

.input-box input{

    width:100%;
    height:100%;

    background:transparent;

    border:2px solid rgba(255,255,255,0.2);

    border-radius:40px;

    outline:none;

    color:white;

    font-size:16px;

    padding:20px 50px 20px 20px;
}

.input-box input::placeholder{
    color:white;
}

.input-box i{

    position:absolute;

    right:20px;

    top:50%;

    transform:translateY(-50%);

    font-size:22px;
}

.btn{

    width:100%;

    height:50px;

    border:none;

    outline:none;

    border-radius:40px;

    background:white;

    color:#111827;

    font-size:16px;

    font-weight:bold;

    cursor:pointer;

    transition:0.3s;
}

.btn:hover{

    background:#2563eb;

    color:white;
}

.register-link{

    text-align:center;

    margin-top:20px;
}

.register-link a{

    color:white;

    text-decoration:none;

    font-weight:bold;
}

.register-link a:hover{
    text-decoration:underline;
}

</style>

</head>
<body>

<div class="wrapper">

<div class="logo">
👟
</div>

<h1>Login</h1>

<form action="LoginServlet" method="post">

<div class="input-box">

<input type="email"
name="email"
placeholder="Enter Email"
required>

<i class='bx bxs-envelope'></i>

</div>

<div class="input-box">

<input type="password"
name="password"
placeholder="Enter Password"
required>

<i class='bx bxs-lock-alt'></i>

</div>

<button type="submit" class="btn">
Login
</button>

</form>

<div class="register-link">

<p>
Don't have an account?
<a href="register.jsp">Register</a>
</p>

</div>

</div>

</body>
</html>