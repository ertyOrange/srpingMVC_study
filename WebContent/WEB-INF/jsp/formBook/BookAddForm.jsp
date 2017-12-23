<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Book Form</title>
</head>
<body>
	<div id="global">
		<form:form modelAttribute="book" action="book_save" method="post">
			<fieldset>
				<legend>Add a Book</legend>
				<p>
					<label for="category">category:</label>
					<form:select id="category" path="category.id"
						items="${categories}" itemLabel="name" itemVlue="id" />
				</p>
				<p>
					<label for="title">Title:</label>
					<form:input id="title" path="title"/>
				</p>
				<p>
					<label for="author">Author:</label>
					<form:input id="author" path="author"/>
				</p>
				<p>
					<label for="isbn">ISBN:</label>
					<form:input id="isbn" path="isbn"/>
				</p>
				<p id="buttons">
					<input id="reset" type="reset" tabindex="4"> <input
						id="submit" type="submit" tabindex="5" value="Add Book">
				</p>
			</fieldset>
		</form:form>
	</div>
</body>
</html>