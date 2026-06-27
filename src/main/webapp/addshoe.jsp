<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Shoe</title>
</head>

<body>

<h2>Add Shoe</h2>

<form action="AddShoeServlet"
method="post">

Name:
<input type="text"
name="shoeName"><br><br>

Brand:
<input type="text"
name="brand"><br><br>

Category:

<select name="category">

<option>Men</option>

<option>Women</option>

<option>Kids</option>

</select>

<br><br>

Description:

<textarea
name="description">
</textarea>

<br><br>

Price:

<input type="number"
name="price">

<br><br>

Sizes:

<input type="text"
name="sizes"
placeholder="6,7,8,9,10">

<br><br>

Image Name:

<input type="text"
name="image">

<br><br>

Stock:

<input type="number"
name="stock">

<br><br>

Status:

<select name="status">

<option>
Available
</option>

<option>
Out Of Stock
</option>

</select>

<br><br>

<button>
Save Shoe
</button>

</form>

</body>
</html>