<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.IOException"%>
<%@ page import="javax.servlet.annotation.WebServlet"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="fr.imie.supcommerce.dao.ProductDao"%>
<%@ page import="fr.imie.supcommerce.model.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Product</title>
	</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
	<form action="addProduct" method="post">
		<br>Name :<br> 
		<input type="text" name="name">
		<br>Description :<br>
		<input type="text" name="description">
		<br>Price :<br>
		<input type="text" name="price">
		<input type="submit" value="ok">
	</form>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>