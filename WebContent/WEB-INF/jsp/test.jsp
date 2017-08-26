<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<fmt:message key="i18n.username"></fmt:message>


<br><br>
<fmt:message key="i18n.password"></fmt:message>

</body>
</html>