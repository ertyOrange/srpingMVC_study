<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="scripts\jquery-3.2.1.min.js"></script>
<script>
$(function (){
	$("#testJson").click(function(){
		var url=this.href;
		var args={};
		$.post(url,args,function(data){
			for (var i =0;i<data.length;i++){
				var id =data[i].id;
				var lastName=data[i].lastName;
				alert(id+":"+lastName);
			}
		});
		return false;
	});
})
</script>

</head>
<body>
<a href="testJson" id="testJson">TestJson</a>
<br>
<br>


<h1>to person</h1>
<form action="topersion" method="post">
personName:<input type="text" name="name" value="Yang">
<br>
<br>
age:<input type="text" name="age" >

<br>
<br>
city:<input type="text" name="address.city">
<br>
<br>
province:<input type="text" name="address.province">
<br>
<br>
<input type="submit" value="Submit">
</form>
<br>
<a href="testParamsAndHeaders?userName=user&age=20">testParamsAndHeaders</a>
<br>
<br>
<a href="testAnt/123/abc">/testAnt/*/abc</a>

<br>
<br>
<a href="testPathVariable/89">testPathVariable</a>

<br>
<br>
<a href="testReqestParam?userName=yanghaoxiang&age=11">testReqestParam</a>
<br>
<br>
<a href="testReqestParam?userName=yanghaoxiang">testReqestParam +no age</a>
<br><br>
<a href="testModelAndView">testModelAndView</a>

<br><br>
<a href="testMap">testMap</a>

<br><br>
<a href="testSessionAttribute">testSessionAttribute</a>

<br><br>

<a href="exception">testexceptionHandle</a>


<br><br>
<form action="testModelAttribute" method="post">
personName:<input type="text" name="name" value="Yang">
<br>

<br>
<input type="submit" value="Submit">
</form>
<br>


<br><br>
<a href="testRedirect">test Redirect</a>
<br><br>

<a href="book_input">book_input</a>

<br><br>
<a href="testRedirect">test Redirect</a>
<br><br>
<a href="session/test/11/erty"> test testHttpSession</a>
<br><br>
<a href="emps">all  emps</a>



<br><br>
<form action="testHttpMessageConverter" method="post" enctype="multipart/form-data">
File :<input type="file" name="file"/>
Desc :<input type="text" name="desc"/>
<input type="submit" value="Submit">
</form>

<br><br>

<a href="testtestResponseEntity">testtestResponseEntity</a>

</body>
</html>