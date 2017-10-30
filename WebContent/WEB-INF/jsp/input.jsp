<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
使用WHY标签
1 ，可以快速的开发出表单
2 ，可以更方便的进行表单的回显

3， 需要注意
	可以通过modelAttribute 属性指定绑定的模型属性
	若没有指定的属性，则从默认的request域对象中读取command 的表单的bean
	如果属性值也不存在，就会发生错误
 -->
	<form:form action="emp" method="POST" modelAttribute="employee">
		<!-- path 属性对应HTML表单的name属性 -->
		LastName :<form:input path="lastName" />
		<br>
		
		Email :<form:input path="email" />
		<br>
		<%
			Map<String, String> genders = new HashMap();
				genders.put("1", "Male");
				genders.put("0", "Female");
				request.setAttribute("genders", genders);
		%>
		<br>
		Gender: 
		<br>
		<form:radiobuttons path="gender" items="${genders}" delimiter="<br>"/>
		<br>
		<br>
		Department:  <form:select path="department.id" items="${departments}"
			itemLabel="departmantName" itemValue="id" ></form:select>
		<br>

		<input type="submit" value="Submit">
	</form:form>



</body>
</html>