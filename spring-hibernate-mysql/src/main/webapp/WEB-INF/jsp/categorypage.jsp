<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Categories</title>
</head>
<body>
<h1>Categories</h1>

<c:url var="addUrl" value="/symph/catView/cats/add" />
<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#fcf">
		<tr>
			<th>Cat Id</th>
			<th>Cat name</th>
			<th>Cat Desc</th>
			<th colspan="3"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${cats}" var="cat">
			<c:url var="editUrl" value="/symph/catView/cats/edit?id=${cat.catId}" />
			<c:url var="deleteUrl" value="/symph/catView/cats/delete?id=${cat.catId}" />
		<tr>
			<td><c:out value="${cat.catId}" /></td>
			<td><c:out value="${cat.catName}" /></td>
			<td><c:out value="${cat.catDesc}" /></td>
			<%-- <td><a href="${editUrl}">Edit</a></td>
			<td><a href="${deleteUrl}">Delete</a></td>
			<td><a href="${addUrl}">Add</a></td> --%>
		</tr>
	</c:forEach>
	</tbody>
</table>

<c:if test="${empty cats}">
	There are currently no Categories in the list. <a href="${addUrl}">Add</a> a Category.
</c:if>

</body>
</html>