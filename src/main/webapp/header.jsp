<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<c:set var="context" value="${pageContext.request.contextPath}"/>
	<ul>
		<li>
			<a href="<c:out value="${context}"/>/listProduct">List Product</a>
		</li>
		<c:choose>
			<c:when test="${empty sessionScope.User}">
				<li><a href="<c:out value="${context}"/>/login">Login</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="<c:out value="${context}"/>/auth/addProduct">Add Product</a></li>
				<li><a href="<c:out value="${context}"/>/auth/addCategory">Add Category</a></li>
				<li><a href="<c:out value="${context}"/>/logout">Logout</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</header>