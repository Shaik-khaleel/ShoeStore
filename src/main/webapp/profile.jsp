<%@ page import="com.shoes.model.User" %>

<%
User user =
(User)session.getAttribute("user");

if(user==null){

    response.sendRedirect("login.jsp");
    return;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Arial,sans-serif;
}

body{
background:#f4f4f4;
}

/* Navbar */

.navbar{
background:#131921;
padding:20px 40px;
display:flex;
justify-content:space-between;
align-items:center;
}

.logo{
color:white;
font-size:28px;
font-weight:bold;
}

.navbar a{
color:white;
text-decoration:none;
margin-left:20px;
font-size:17px;
}

.navbar a:hover{
color:#facc15;
}

/* Profile Card */

.container{
width:100%;
display:flex;
justify-content:center;
margin-top:50px;
}

.profile-card{
background:white;
width:500px;
padding:35px;
border-radius:15px;
box-shadow:0px 0px 15px rgba(0,0,0,0.15);
text-align:center;
}

.profile-img{
width:120px;
height:120px;
border-radius:50%;
background:#2563eb;
color:white;
font-size:45px;
font-weight:bold;
display:flex;
justify-content:center;
align-items:center;
margin:auto;
margin-bottom:20px;
}

.profile-card h2{
margin-bottom:20px;
color:#111827;
}

.info{
text-align:left;
margin-top:20px;
}

.info p{
padding:12px;
border-bottom:1px solid #ddd;
font-size:17px;
}

.label{
font-weight:bold;
color:#2563eb;
}

.btn{
display:inline-block;
margin-top:25px;
padding:12px 25px;
background:#2563eb;
color:white;
text-decoration:none;
border-radius:6px;
font-size:16px;
}

.btn:hover{
background:#1d4ed8;
}

.logout{
background:red;
margin-left:10px;
}

.logout:hover{
background:#cc0000;
}

</style>

</head>
<body>

<div class="navbar">

<div class="logo">
 Shoe Store
</div>

<div>

<a href="HomeServlet">Home</a>

<a href="CartServlet">Cart</a>

<a href="MyOrdersServlet">Orders</a>

<a href="profile.jsp">Profile</a>

</div>

</div>

<div class="container">

<div class="profile-card">

<div class="profile-img">
<%=user.getName().substring(0,1).toUpperCase()%>
</div>

<h2>My Profile</h2>

<div class="info">

<p>
<span class="label">Name :</span>
<%=user.getName()%>
</p>

<p>
<span class="label">Email :</span>
<%=user.getEmail()%>
</p>

<p>
<span class="label">Mobile :</span>
<%=user.getMobile()%>
</p>

<p>
<span class="label">Address :</span>
<%=user.getAddress()%>
</p>

</div>

<a href="MyOrdersServlet" class="btn">
My Orders
</a>

<a href="LogoutServlet" class="btn logout">
Logout
</a>

</div>

</div>

</body>
</html>