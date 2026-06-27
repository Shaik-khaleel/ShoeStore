<%@ page import="java.util.*" %>
<%@ page import="com.shoes.model.Order" %>

<%
@SuppressWarnings("unchecked")
List<Order> orders =
(List<Order>)request.getAttribute("orders");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Orders</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial,sans-serif;
}

body{
    background:#f4f6f9;
    padding:30px;
}

h1{
    text-align:center;
    margin-bottom:30px;
    color:#1e293b;
}

.container{
    width:95%;
    margin:auto;
}

table{
    width:100%;
    border-collapse:collapse;
    background:white;
    box-shadow:0 2px 10px rgba(0,0,0,0.1);
    border-radius:10px;
    overflow:hidden;
}

th{
    background:#2563eb;
    color:white;
    padding:15px;
    text-align:center;
}

td{
    padding:15px;
    text-align:center;
    border-bottom:1px solid #e5e7eb;
}

tr:hover{
    background:#f8fafc;
}

select{
    padding:8px;
    border:1px solid #ccc;
    border-radius:5px;
}

button{
    background:#16a34a;
    color:white;
    border:none;
    padding:8px 15px;
    border-radius:5px;
    cursor:pointer;
    margin-top:5px;
}

button:hover{
    background:#15803d;
}

.status{
    font-weight:bold;
}

.back-btn{
    display:inline-block;
    margin-bottom:20px;
    padding:10px 20px;
    background:#2563eb;
    color:white;
    text-decoration:none;
    border-radius:5px;
}

.back-btn:hover{
    background:#1d4ed8;
}

</style>

</head>

<body>

<div class="container">

<a href="AdminDashboardServlet"
class="back-btn">
 Back to Dashboard
</a>

<h1>Customer Orders</h1>

<table>

<tr>
<th>Order ID</th>
<th>Shoe Name</th>
<th>Total Price</th>
<th>Order Status</th>
<th>Update Status</th>
</tr>

<%
if(orders!=null){

for(Order order : orders){
%>

<tr>

<td>
<%=order.getId()%>
</td>

<td>
<%=order.getShoeName()%>
</td>

<td>
<%=order.getTotal()%>
</td>

<td class="status">
<%=order.getOrderStatus()%>
</td>

<td>

<form action="UpdateOrderStatusServlet"
method="post">

<input type="hidden"
name="orderId"
value="<%=order.getId()%>">

<select name="status">

<option>Order Placed</option>

<option>Processing</option>

<option>Shipped</option>

<option>Out For Delivery</option>

<option>Delivered</option>

<option>Cancelled</option>

</select>

<br><br>

<button type="submit">
Update
</button>

</form>

</td>

</tr>

<%
}
}
%>

</table>

</div>

</body>
</html>