<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/testConversionserviceConnerter" method="POST">
	<!-- lastName-email-gender-birth eg:yang-26337442@qq.com-0-19910909     -->
	employee:<input type="text" name="employee"/>
	<input type="submit" value="Submit">
</form>
<br>
<br>
<br>




	<!-- 
使用WHY标签
1 ，可以快速的开发出表单
2 ，可以更方便的进行表单的回显

3， 需要注意
	可以通过modelAttribute 属性指定绑定的模型属性
	若没有指定的属性，则从默认的request域对象中读取command 的表单的bean
	如果属性值也不存在，就会发生错误
 -->
	<form:form action="${pageContext.request.contextPath}/emp" method="POST" commandName="employee">
		<!-- path 属性对应HTML表单的name属性 -->
		
		<c:if test="${employee.id ==null }">
		LastName :<form:input path="lastName" />
		</c:if>
		<!-- -->
		<c:if test="${employee.id !=null }">
		<form:hidden path="id"/>
		<input type="hidden" value="PUT" name="_method">
		</c:if>
		 
		<br>
		
		Email :<form:input path="email" />
		<br>
		<%
			Map<String, String> genders = new HashMap();
				genders.put("0", "Male");
				genders.put("1", "Female");
				request.setAttribute("genders", genders);
		%>
		<br>
		Gender: 
		<br>
		<!--  
			1 数据类型转换的
			2 数据类型格式化
			3 数据校验
		
		
		<br>
		Birth:<form:input path="birth"/>
		<br>
		-->
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