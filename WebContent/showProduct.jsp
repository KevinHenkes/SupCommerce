<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.IOException"%>
<%@ page import="javax.servlet.annotation.WebServlet"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="fr.imie.supcommerce.dao.ProductDao"%>
<%@ page import="fr.imie.supcommerce.model.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Show Product</title>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
			<c:choose>
				<c:when test="${empty product}">
					<p><c:out value="No product" /></p>
				</c:when>
				<c:otherwise>
					<b><c:out value="${product.name}" /></b><br>
					<c:out value="${product.description}" /><br>
					<c:out value="${product.price}" /><br><br>
				</c:otherwise>
			</c:choose>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>