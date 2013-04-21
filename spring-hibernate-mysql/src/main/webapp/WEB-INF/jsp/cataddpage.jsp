<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Create New Category</h1>

<c:url var="saveUrl" value="/symph/catView/cats/add" />
<form:form modelAttribute="categoryAttribute" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="catName">Category Name:</form:label></td>
			<td><form:input path="CatName"/></td>
		</tr>

		<tr>
			<td><form:label path="catDesc">Category desc</form:label></td>
			<td><form:input path="catDesc"/></td>
		</tr>
		
		<%-- <tr>
			<td><form:label path="money">Money</form:label></td>
			<td><form:input path="money"/></td>
		</tr> --%>
	</table>
	
	<input type="submit" value="Save" />
</form:form>

</body>
</html>