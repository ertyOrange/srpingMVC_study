<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jsp list</title>

<!-- 处理静态资源 
	1. 为什么会有这样的问题；
	优雅的REST风格的资源URL  不希望.html 或者.do 等后缀
	若将dispatcherServlet请求映射配置为/
	则Spring MVC 将捕获WEB容器的所有请求，包括静态资源的请求
	Spring MVC会将其作为普通的请求来处理，因而就找不到对应处理器导致错误
	2. 解决
	（1）处理后缀的解决方案
	（2）配置文件中配置<MVC :default-servlet-handler/>
-->

<script type="text/javascript" src="scripts/jquery-3.2.1.min.js"></script>
<script>
$(function(){

	$(".delete").click(
			function(){
				var href=$(this).attr("href");
				$("form").attr("action",href).submit();
				return false;
			});
})
</script>
</head>
<body>

	<form action="" method="POST">
	<input type="hidden" name="_method" value="DELETE">
	</form>
	<fmt:if test="${empty requestScope.employees}">
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

			<fmt:forEach items="${requestScope.employees}" var="emp">

				<tr>
					<th>${emp.id}</th>
					<th>${emp.lastName}</th>
					<th>${emp.email}</th>
					<th>${emp.gender ==1 ? 'famale' :'male'}</th>
					<th>${emp.department.departmantName}</th>
					<th><a href="">Edit</a></th>
					<th><a class="delete" href="emp/${emp.id}">Delete</a></th>
				</tr>
			</fmt:forEach>
		</table>

	</fmt:if>


	<br>
	<br>

	<a href="emp">Add New Employee</a>

</body>
</html>