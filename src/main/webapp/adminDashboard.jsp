<%@ page import="java.util.*" %>
<%@ page import="com.shoes.model.Shoe" %>

<%
String admin =
(String)session.getAttribute("admin");

if(admin==null){

    response.sendRedirect("adminLogin.jsp");
    return;
}
%>

<%
@SuppressWarnings("unchecked")
List<Shoe> shoeList =
(List<Shoe>)request.getAttribute("shoeList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>

<style>

body{
    font-family:Arial,sans-serif;
    background:#f2f2f2;
    margin:0;
    padding:20px;
}

h1{
    text-align:center;
    color:#333;
}

.actions{
    text-align:center;
    margin-bottom:20px;
}

.btn{
    padding:10px 18px;
    color:white;
    text-decoration:none;
    border-radius:5px;
    font-weight:bold;
    margin:5px;
    display:inline-block;
}

.add{
    background:green;
}

.orders{
    background:#2563eb;
}

.edit{
    background:orange;
}

.delete{
    background:red;
}

table{
    width:95%;
    margin:auto;
    background:white;
    border-collapse:collapse;
    box-shadow:0 2px 10px rgba(0,0,0,0.1);
}

th,td{
    padding:12px;
    border:1px solid #ddd;
    text-align:center;
}

th{
    background:#2563eb;
    color:white;
}

img{
    border-radius:5px;
}

</style>

</head>
<body>

<h1>Admin Dashboard</h1>

<div class="actions">

    <a href="addShoe.jsp"
       class="btn add">
       Add New Shoe
    </a>

    <a href="AdminOrdersServlet"
       class="btn orders">
       Manage Orders
    </a>

</div>

<table>

<tr>
    <th>ID</th>
    <th>Image</th>
    <th>Name</th>
    <th>Brand</th>
    <th>Price</th>
    <th>Stock</th>
    <th>Status</th>
    <th>Action</th>
</tr>

<%
if(shoeList != null){

for(Shoe shoe : shoeList){
%>

<tr>

    <td><%=shoe.getId()%></td>

    <td>
        <img src="images/<%=shoe.getImage()%>"
             width="80"
             height="80">
    </td>

    <td><%=shoe.getShoeName()%></td>

    <td><%=shoe.getBrand()%></td>

    <td>Rs : <%=shoe.getPrice()%></td>

    <td><%=shoe.getStock()%></td>

    <td><%=shoe.getStatus()%></td>

    <td>

        
        <a class="btn edit" href="EditShoeServlet?id=<%=shoe.getId()%>">Edit</a>
           
        

        <a class="btn delete"
           href="DeleteShoeServlet?id=<%=shoe.getId()%>"
           onclick="return confirm('Are you sure you want to delete this shoe?');">
           Delete
        </a>

    </td>

</tr>

<%
}
}
%>

</table>

</body>
</html>