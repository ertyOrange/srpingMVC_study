<%@ page language="java" contentType="text/html; charset=utf-8"pageEncoding="utf-8"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
test page!!!
<br><br>
testModelAndView-- requestScope.time: ${requestScope.time} 
<br><br>
testMap-- requestScope.input: ${requestScope.input} 
<br><br>
testSessionAttribute--requestScope.pserson: ${requestScope.person} 	
<br><br>
testSessionAttribute--sessionScope.pserson: ${sessionScope.person} 
<br><br>
<c:message key="i18n.username"></c:message>
<br><br>
<c:message key="i18n.password"></c:message>


<fmt:if test ="${empty requestScope.employees}">
</fmt:if>
<fmt:if test="${!empty requestScope.employees}">
	<table>
	<tr>
		<th>ID</th>
		<th>LastName</th>
		<th>Email</th>
		<th>Gender</th>
		<th>Department</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	
	<fmt:forEach items ="${requestScope.employees}" var="emp">
	
	<tr>
		<th>${emp.id}</th>
		<th>${emp.lastName}</th>
		<th>${emp.email}</th>
		<th>${emp.gender ==1 ? 'famale' :'male'}</th>
		<th>${emp.department.departmantName}</th>
		<th><a href="">Edit</a></th>
		<th><a href="">Delete</a></th> 
	</tr>
	</fmt:forEach>
	</table>

</fmt:if>




</body>
</html>