<%@ page import="java.util.*"%>
<%@ page import="com.shoes.model.Order"%>

<%

@SuppressWarnings("unchecked")
List<Order> orders =
(List<Order>)request.getAttribute("orders");
%>

<!DOCTYPE html>
<html>
<head>
<title>My Orders</title>
</head>

<body>

<h1>My Orders</h1>

<%
for(Order o : orders){
%>


<style>
.order-card{

display:flex;

background:white;

padding:20px;

margin:20px;

border-radius:10px;

box-shadow:
0 2px 10px rgba(0,0,0,.2);
}

.order-card img{

width:150px;

height:150px;

object-fit:cover;

margin-right:20px;
}
</style>

<div class="order-card">

<img
src="images/<%=o.getImage()%>">

<div>

<h2>
<%=o.getShoeName()%>
</h2>

<p>
Size :
<%=o.getSize()%>
</p>

<p>
Qty :
<%=o.getQuantity()%>
</p>

<p>
Rs : <%=o.getTotal()%>
</p>

<p>
Status :
<%=o.getOrderStatus()%>
</p>

</div>

</div>

<%
}
%>

</body>
</html>