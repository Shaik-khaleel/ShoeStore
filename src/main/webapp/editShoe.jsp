
<%@ page import="com.shoes.model.Shoe" %>

<%
Shoe shoe = (Shoe)request.getAttribute("shoe");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Shoe</title>

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Segoe UI',Tahoma,Geneva,Verdana,sans-serif;
}

body{

    background:linear-gradient(135deg,#2563eb,#1e3a8a);
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    padding:40px;
}

.container{

    width:700px;
    background:white;
    border-radius:15px;
    box-shadow:0 10px 30px rgba(0,0,0,.25);
    overflow:hidden;
}

.header{

    background:#2563eb;
    color:white;
    text-align:center;
    padding:20px;
}

.header h2{

    font-size:32px;
    letter-spacing:1px;
}

.form{

    padding:35px;
}

.row{

    margin-bottom:20px;
}

label{

    display:block;
    margin-bottom:8px;
    font-weight:bold;
    color:#333;
}

input,
select,
textarea{

    width:100%;
    padding:12px;
    border:1px solid #ccc;
    border-radius:8px;
    font-size:16px;
    transition:.3s;
}

input:focus,
select:focus,
textarea:focus{

    outline:none;
    border-color:#2563eb;
    box-shadow:0 0 8px rgba(37,99,235,.3);
}

textarea{

    height:120px;
    resize:none;
}

button{

    width:100%;
    padding:15px;
    border:none;
    border-radius:8px;
    background:#2563eb;
    color:white;
    font-size:18px;
    font-weight:bold;
    cursor:pointer;
    transition:.3s;
}

button:hover{

    background:#1d4ed8;
}

.back{

    display:block;
    margin-top:20px;
    text-align:center;
    text-decoration:none;
    color:#2563eb;
    font-weight:bold;
}

.back:hover{

    color:#1d4ed8;
}

</style>

</head>

<body>

<div class="container">

<div class="header">

<h2>Edit Shoe</h2>

</div>

<div class="form">

<form action="UpdateShoeServlet" method="post">

<input type="hidden"
name="id"
value="<%=shoe.getId()%>">

<div class="row">

<label>Shoe Name</label>

<input type="text"
name="shoeName"
value="<%=shoe.getShoeName()%>">

</div>

<div class="row">

<label>Brand</label>

<input type="text"
name="brand"
value="<%=shoe.getBrand()%>">

</div>

<div class="row">

<label>Category</label>

<select name="category">

<option value="Men"
<%=shoe.getCategory().equals("Men")?"selected":""%>>
Men
</option>

<option value="Women"
<%=shoe.getCategory().equals("Women")?"selected":""%>>
Women
</option>

<option value="Kids"
<%=shoe.getCategory().equals("Kids")?"selected":""%>>
Kids
</option>

</select>

</div>

<div class="row">

<label>Description</label>

<textarea name="description"><%=shoe.getDescription()%></textarea>

</div>

<div class="row">

<label>Price</label>

<input type="number"
step="0.01"
name="price"
value="<%=shoe.getPrice()%>">

</div>

<div class="row">

<label>Sizes</label>

<input type="text"
name="sizes"
value="<%=shoe.getSizes()%>">

</div>

<div class="row">

<label>Image Name</label>

<input type="text"
name="image"
value="<%=shoe.getImage()%>">

</div>

<div class="row">

<label>Stock</label>

<input type="number"
name="stock"
value="<%=shoe.getStock()%>">

</div>

<div class="row">

<label>Status</label>

<select name="status">

<option value="Available"
<%=shoe.getStatus().equals("Available")?"selected":""%>>
Available
</option>

<option value="Out Of Stock"
<%=shoe.getStatus().equals("Out Of Stock")?"selected":""%>>
Out Of Stock
</option>

</select>

</div>

<button type="submit">

Update Shoe

</button>

</form>

<a href="AdminDashboardServlet" class="back">

Back to Dashboard

</a>

</div>

</div>

</body>
</html>
