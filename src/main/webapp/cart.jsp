<%@ page import="java.util.*" %>
<%@ page import="com.shoes.model.Cart" %>
<%@ page import="com.shoes.model.User" %>
<%
User user=(User)session.getAttribute("user");
if(user==null){
    response.sendRedirect("login.jsp");
    return;
}
@SuppressWarnings("unchecked")
List<Cart> cartList=(List<Cart>)request.getAttribute("cartList");
double total=0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Cart</title>
<style>
*{margin:0;padding:0;box-sizing:border-box;font-family:Arial,sans-serif}
body{background:#f4f6f9}
.container{width:95%;max-width:1200px;margin:40px auto}
h1{text-align:center;margin-bottom:25px;color:#222}
.card{display:flex;gap:20px;background:#fff;border-radius:12px;padding:20px;
box-shadow:0 8px 20px rgba(0,0,0,.1);margin-bottom:20px;align-items:center}
.card img{width:180px;height:180px;object-fit:cover;border-radius:10px}
.info{flex:1}
.info h2{margin-bottom:10px}
.info p{margin:8px 0;font-size:16px}
.qty{display:flex;align-items:center;gap:12px;margin:12px 0}
.qty a{text-decoration:none}
.qty button{width:36px;height:36px;border:none;border-radius:50%;
background:#2563eb;color:#fff;font-size:20px;cursor:pointer}
.remove{display:inline-block;margin-top:12px;background:#dc2626;color:#fff;
padding:10px 20px;text-decoration:none;border-radius:6px;font-weight:bold}
.totalCard{background:#fff;padding:20px;border-radius:12px;
box-shadow:0 8px 20px rgba(0,0,0,.1);margin-top:20px}
.total{font-size:30px;color:#16a34a;font-weight:bold;text-align:right}
.actions{display:flex;justify-content:center;gap:20px;flex-wrap:wrap;margin-top:25px}
.btn{text-decoration:none;color:#fff;padding:14px 28px;border-radius:8px;font-weight:bold}
.shop{background:#2563eb}.clear{background:#dc2626}.checkout{background:#16a34a}
.empty{text-align:center;font-size:26px;margin:60px;color:#666}
@media(max-width:768px){
.card{flex-direction:column;text-align:center}
.card img{width:220px;height:220px}
.total{text-align:center}
}
</style>
</head>
<body>
<div class="container">
<h1> My Shopping Cart</h1>
<%
if(cartList!=null && !cartList.isEmpty()){
 for(Cart cart:cartList){
   double sub=cart.getPrice()*cart.getQuantity();
   total+=sub;
%>
<div class="card">
<img src="images/<%=cart.getImage()%>" alt="">
<div class="info">
<h2><%=cart.getShoeName()%></h2>
<p><b>Size:</b> <%=cart.getSize()%></p>
<p><b>Price:</b> Rs : <%=cart.getPrice()%></p>
<div class="qty">
<a href="UpdateQuantityServlet?cartId=<%=cart.getId()%>&quantity=<%=cart.getQuantity()-1%>"><button>-</button></a>
<b><%=cart.getQuantity()%></b>
<a href="UpdateQuantityServlet?cartId=<%=cart.getId()%>&quantity=<%=cart.getQuantity()+1%>"><button>+</button></a>
</div>
<p><b>Subtotal:</b> Rs : <%=sub%></p>
<a class="remove" href="RemoveCartServlet?id=<%=cart.getId()%>">Remove Item</a>
</div>
</div>
<% } %>
<div class="totalCard">
<div class="total">Grand Total : Rs <%=total%></div>
<div class="actions">
<a href="HomeServlet" class="btn shop">Continue Shopping</a>
<a href="ClearCartServlet" class="btn clear">Clear Cart</a>
<a href="checkout.jsp" class="btn checkout">Proceed to Checkout</a>
</div>
</div>
<% } else { %>
<div class="empty">
Your cart is empty.<br><br>
<a href="HomeServlet" class="btn shop">Start Shopping</a>
</div>
<% } %>
</div>
</body>
</html>