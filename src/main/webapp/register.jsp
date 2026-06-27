<%@ page language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shoe Store Register</title>

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

width:450px;

background:rgba(255,255,255,0.08);

border:2px solid rgba(255,255,255,0.2);

backdrop-filter:blur(15px);

border-radius:15px;

padding:35px 40px;

color:white;
}

.logo{
text-align:center;
font-size:50px;
margin-bottom:10px;
}

h1{
text-align:center;
margin-bottom:20px;
}

.input-box{
position:relative;
width:100%;
height:55px;
margin:15px 0;
}

.input-box input{

width:100%;
height:100%;

background:transparent;

border:2px solid rgba(255,255,255,0.2);

border-radius:40px;

outline:none;

color:white;

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

border-radius:40px;

background:white;

font-size:16px;

font-weight:bold;

cursor:pointer;
}

.btn:hover{
background:#2563eb;
color:white;
}

.link{
text-align:center;
margin-top:20px;
}

.link a{
color:white;
font-weight:bold;
text-decoration:none;
}

</style>

</head>
<body>

<div class="wrapper">

<div class="logo">👟</div>

<h1>Register</h1>

<form action="RegisterServlet" method="post">

<div class="input-box">
<input type="text" name="name"
placeholder="Full Name" required>
<i class='bx bxs-user'></i>
</div>

<div class="input-box">
<input type="email" name="email"
placeholder="Email Address" required>
<i class='bx bxs-envelope'></i>
</div>

<div class="input-box">
<input type="password" name="password"
placeholder="Password" required>
<i class='bx bxs-lock-alt'></i>
</div>

<div class="input-box">
<input type="text" name="mobile"
placeholder="Mobile Number" required>
<i class='bx bxs-phone'></i>
</div>

<div class="input-box">
<input type="text" name="address"
placeholder="Address" required>
<i class='bx bxs-home'></i>
</div>

<button class="btn">
Register
</button>

</form>

<div class="link">

Already have an account?
<a href="login.jsp">Login</a>

</div>

</div>

</body>
</html>