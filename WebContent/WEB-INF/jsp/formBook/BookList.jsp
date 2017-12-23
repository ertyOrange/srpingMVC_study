<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book List</title>
</head>
<body>
	<div id="global">
		<h1>BookList</h1>
		<table>
			<tr>
				<th>Category</th>
				<th>&nbsp;</th>
				<th>Title</th>
				<th>&nbsp;</th>
				<th>ISBN</th>
				<th>&nbsp;</th>
				<th>Author</th>
				<th>&nbsp;</th>
				<th>Edit</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.category.name}</td>
					<th>&nbsp;</th>
					<td>${book.title}</td>
					<th>&nbsp;</th>
					<td>${book.isbn}</td>
					<th>&nbsp;</th>
					<td>${book.author}</td>
					<th>&nbsp;</th>
					<td><a href="book_edit/${book.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
		<div>&nbsp;</div>
		<a href="book_input">Add Book</a>
	</div>
</body>
</html>