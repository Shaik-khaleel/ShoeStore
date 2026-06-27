<%@ page import="java.util.*" %>
<%@ page import="com.shoes.model.Shoe" %>

<%
@SuppressWarnings("unchecked")
List<Shoe> shoeList =
(List<Shoe>) request.getAttribute("shoeList");

if(shoeList == null){
    shoeList = new ArrayList<Shoe>();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shoe Store</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Arial,sans-serif;
}

body{
background:#f5f5f5;
}

.navbar{
background:#131921;
height:70px;
display:flex;
justify-content:space-between;
align-items:center;
padding:0 40px;
}

.logo{
color:white;
font-size:28px;
font-weight:bold;
}

.menu a{
color:white;
text-decoration:none;
margin-left:20px;
font-size:16px;
}

.menu a:hover{
color:#facc15;
}

.category{
display:flex;
justify-content:center;
gap:20px;
padding:25px;
}

.category a{
text-decoration:none;
background:#2563eb;
color:white;
padding:12px 25px;
border-radius:5px;
font-weight:bold;
}

.category a:hover{
background:#1d4ed8;
}

.container{
width:90%;
margin:auto;
display:grid;
grid-template-columns:repeat(auto-fill,minmax(250px,1fr));
gap:25px;
padding-bottom:50px;
}

.card{
background:white;
border-radius:10px;
overflow:hidden;
box-shadow:0 0 10px rgba(0,0,0,.2);
transition:.3s;
}

.card:hover{
transform:translateY(-5px);
}

.card img{
width:100%;
height:220px;
object-fit:cover;
}

.card-body{
padding:15px;
}

.card h3{
margin-bottom:10px;
}

.brand{
color:gray;
margin-bottom:8px;
}

.price{
font-size:22px;
font-weight:bold;
color:green;
margin-bottom:10px;
}

.status{
color:red;
margin-bottom:10px;
}

select{
width:100%;
padding:10px;
margin-bottom:10px;
}

.btn{
width:100%;
padding:12px;
border:none;
background:#f59e0b;
color:white;
font-size:16px;
cursor:pointer;
border-radius:5px;
}

.btn:hover{
background:#d97706;
}

.empty{
text-align:center;
font-size:22px;
color:red;
padding:50px;
}

footer{
background:#131921;
color:white;
padding:20px;
text-align:center;
margin-top:50px;
}

</style>

</head>
<body>

<div class="navbar">

<div class="logo">
Shoe Store
</div>

<div class="menu">
<a href="HomeServlet">Home</a>
<a href="CartServlet">Cart</a>
<a href="MyOrdersServlet">Orders</a>
<a href="login.jsp">Login</a>
<a href="register.jsp">Register</a>
<a href="profile.jsp">Profile</a>
<a href="LogoutServlet">Logout</a>

</div>

</div>

<div class="category">

<a href="HomeServlet?category=Men">
Men Shoes
</a>

<a href="HomeServlet?category=Women">
Women Shoes
</a>

<a href="HomeServlet?category=Kids">
Kids Shoes
</a>

<a href="HomeServlet">
All Shoes
</a>

</div>


<div class="container">

<%
if(shoeList.size() > 0){

for(Shoe shoe : shoeList){
%>

<div class="card">

<img src="images/<%=shoe.getImage()%>" alt="shoe">

<div class="card-body">

<h3><%=shoe.getShoeName()%></h3>

<p class="brand">
Brand : <%=shoe.getBrand()%>
</p>

<p class="price">
Rs : <%=shoe.getPrice()%>
</p>

<p class="status">
<%=shoe.getStatus()%>
</p>

<form action="AddToCartServlet" method="post">

<input type="hidden"
name="shoeId"
value="<%=shoe.getId()%>">

<select name="size">

<%
String[] sizes = shoe.getSizes().split(",");

for(String size : sizes){
%>

<option value="<%=size.trim()%>">
Size <%=size.trim()%>
</option>

<%
}
%>

</select>

<button type="submit" class="btn">
Add To Cart
</button>

</form>

</div>

</div>

<%
}

}else{
%>

<div class="empty">
No Shoes Found
</div>

<%
}
%>

</div>

<footer>

<p>
© 2026 Shoe Store. All Rights Reserved.
</p>

</footer>

</body>
</html>