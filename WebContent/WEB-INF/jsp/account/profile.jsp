<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>


<fieldset><legend>用户信息</legend>  
<ul>  
    <li><label>用户名:</label><c:out value="${account.username}" /></li>  
    <li><label>密码:</label><c:out value="${account.password}" /></li>  
</ul>  
</fieldset>

</body>
</html>