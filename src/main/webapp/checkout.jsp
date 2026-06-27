<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<style>

*{
margin:0;
padding:0;
box-sizing:border-box;
font-family:Arial,sans-serif;
}

body{
background:#eef2f7;
display:flex;
justify-content:center;
align-items:center;
min-height:100vh;
}

.box{

width:600px;

background:#fff;

padding:35px;

border-radius:15px;

box-shadow:0 15px 35px rgba(0,0,0,.15);

}

h2{

text-align:center;

margin-bottom:25px;

color:#111827;

}

label{

font-weight:bold;

display:block;

margin-top:15px;

margin-bottom:5px;

}

input,
textarea{

width:100%;

padding:12px;

border:1px solid #d1d5db;

border-radius:8px;

font-size:16px;

}

input:focus,
textarea:focus{

outline:none;

border-color:#2563eb;

}

.buttons{

display:flex;

gap:15px;

margin-top:25px;

}

.shop{

flex:1;

background:#2563eb;

color:white;

padding:14px;

text-align:center;

text-decoration:none;

border-radius:8px;

font-weight:bold;

}

.place{

flex:1;

background:#16a34a;

color:white;

padding:14px;

border:none;

border-radius:8px;

font-size:16px;

cursor:pointer;

font-weight:bold;

}

.shop:hover{

background:#1d4ed8;

}

.place:hover{

background:#15803d;

}

.loading{

display:none;

position:fixed;

top:0;

left:0;

width:100%;

height:100%;

background:rgba(255,255,255,.9);

justify-content:center;

align-items:center;

flex-direction:column;

font-size:24px;

font-weight:bold;

}

.loader{

width:70px;

height:70px;

border:8px solid #ddd;

border-top:8px solid #16a34a;

border-radius:50%;

animation:spin 1s linear infinite;

margin-bottom:20px;

}

@keyframes spin{

100%{
transform:rotate(360deg);
}

}

</style>

<script>

function showLoader(){

document.getElementById("loading").style.display="flex";

return true;

}

</script>

</head>

<body>

<div class="loading" id="loading">

<div class="loader"></div>

Placing your order...

</div>

<div class="box">

<h2>Checkout</h2>

<form action="PlaceOrderServlet"
method="post"
onsubmit="return showLoader()">

<label>Full Name</label>

<input
type="text"
name="customerName"
required>

<label>Phone Number</label>

<input
type="text"
name="phone"
required>

<label>Delivery Address</label>

<textarea
name="address"
rows="5"
required></textarea>

<div class="buttons">

<a href="HomeServlet"
class="shop">

Continue Shopping

</a>

<button
type="submit"
class="place">

Place Order

</button>

</div>

</form>

</div>

</body>
</html>