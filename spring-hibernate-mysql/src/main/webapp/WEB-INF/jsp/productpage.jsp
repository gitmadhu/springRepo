<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>
<h1>Products</h1>

<c:url var="addUrl" value="/symph/productView/products/add" />
<c:url var="homeUrl" value="/symph/catView/cats" />
<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#fcf">
		<tr>
			<th>Product Id</th>
			<th>product name</th>
			<th>Product price</th>
			<th colspan="3"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${products}" var="product">
			<c:url var="editUrl" value="/symph/productView/products/edit?id=${product.prodId}" />
			<c:url var="deleteUrl" value="/symph/productView/products/delete?id=${product.prodId}" />
		<tr>
			<td><c:out value="${product.prodId}" /></td>
			<td><c:out value="${product.prodName}" /></td>
			<td><c:out value="${product.prodPrice}" /></td>
			<%-- <td><a href="${editUrl}">Edit</a></td>
			<td><a href="${deleteUrl}">Delete</a></td>
			<td><a href="${addUrl}">Add</a></td> --%>
		</tr>
	</c:forEach>
	</tbody>
</table>

<c:if test="${empty products}">
	There are currently no products in the list. 
</c:if>
<a href="${addUrl}">Add</a> a product.<br>
<a href="${homeUrl}">Home page</a>.
</body>
</html>