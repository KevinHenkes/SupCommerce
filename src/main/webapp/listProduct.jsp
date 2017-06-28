<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.IOException"%>
<%@ page import="javax.servlet.annotation.WebServlet"%>
<%@ page import="javax.servlet.http.HttpServlet"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List Product</title>
	</head>
	<body>
		<jsp:include page="header.jsp"></jsp:include>
			<c:forEach items="${products}" var="p">
				<b><c:out value="${p.name}" /></b><br>
				<c:out value="${p.description}" /><br>
				<c:out value="${p.price}" />
				<form action="auth/removeProduct" method="post">
					 <input type="submit" value="Delete">
					 <input type="hidden" name="remove" value="<c:out value="${p.id}" />">
				</form><br><br>
			</c:forEach>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>