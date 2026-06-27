<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
response.sendRedirect("HomeServlet");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shoe Store</title>

<style>

body{
    margin:0;
    padding:0;
    font-family:Arial,sans-serif;
    background:#f4f4f4;

    display:flex;
    justify-content:center;
    align-items:center;

    height:100vh;
}

.container{
    text-align:center;
}

h1{
    color:#2563eb;
    font-size:40px;
}

p{
    color:#555;
    font-size:18px;
}

</style>

<meta http-equiv="refresh"
      content="2;url=login.jsp">

</head>

<body>

<div class="container">

    <h1> Shoe Store</h1>

    <p>Loading...</p>

</div>

</body>
</html>