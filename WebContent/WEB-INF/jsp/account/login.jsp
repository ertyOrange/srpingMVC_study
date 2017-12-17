<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<fieldset><legend>登录</legend><form:form modelAttribute="account" action="${pageContext.request.contextPath}/login">  
    <form:hidden path="id" />  
    <ul>  
        <li><form:label path="username">用户名:</form:label><form:input  
            path="username" /></li>  
        <li><form:label path="password">密码:</form:label><form:password  
            path="password" /></li>  
        <li>  
        <button type="submit">登录</button>  
        <button type="reset">重置</button>  
        </li>  
    </ul>  
</form:form></fieldset>  
</body>
</html>