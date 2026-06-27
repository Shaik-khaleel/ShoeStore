<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>

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
#111827,
#1e293b,
#dc2626);
}

.wrapper{

width:420px;

background:rgba(255,255,255,0.08);

border:2px solid rgba(255,255,255,0.2);

backdrop-filter:blur(15px);

border-radius:15px;

padding:35px 40px;

color:white;
}

.logo{
text-align:center;
font-size:55px;
margin-bottom:10px;
}

h1{
text-align:center;
margin-bottom:25px;
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
background:#dc2626;
color:white;
}

.back{
text-align:center;
margin-top:20px;
}

.back a{
color:white;
font-weight:bold;
text-decoration:none;
}

</style>

</head>
<body>

<div class="wrapper">

<div class="logo"></div>

<h1>Admin Login</h1>

<form action="AdminLoginServlet" method="post">

<div class="input-box">

<input type="email"
name="email"
placeholder="Admin Email"
required>

<i class='bx bxs-envelope'></i>

</div>

<div class="input-box">

<input type="password"
name="password"
placeholder="Password"
required>

<i class='bx bxs-lock-alt'></i>

</div>

<button class="btn">
Login
</button>

</form>

<div class="back">

<a href="login.jsp">
</a>

</div>

</div>

</body>
</html>