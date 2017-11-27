<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Edit Book Form</title>
	
</head>
<body>
	<div id="global">
		<form:form commandName="book" action="/book_update" method="post">
			<fieldset>
				<legend>Edit a book</legend>
				<form:hidden path="id"/>
				<p>
					<label for="category">Category:</label>
					<form:select id="category" path="category.id" items="${categories }" 
						itemLabel="name" itemValue="id"/>				
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
					<input id="reset" type="reset" tabindex="4">
					<input id="submit" type="submit" tabindex="5" value="Update Book">
				</p>
			</fieldset>
		
		
		
		</form:form>		
	
	
	</div>
</body>
</html>