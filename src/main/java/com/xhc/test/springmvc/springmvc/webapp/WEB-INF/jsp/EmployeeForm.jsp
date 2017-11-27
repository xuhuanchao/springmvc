<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Employee From</title>
</head>
<body>
    <div id="global">
        <form:form commandName="employee" action="employee_save" method="post">
            <fieldset>
                <legend>Add an employee</legend>
                <p>
                    <label for="firstName">First Name:</label>
                    <form:input path="firstName" tabindex="1"/>
                </p>
                <p>
                    <label for="lastName">Last Name:</label>
                    <form:input path="lastName" tabindex="2"/>
                </p>
                <p>
                    <%-- <form:input path="birthDate" cssClass="error"/> --%>
                    ${error }
                </p>
                <p>
                    <label for="birthDate">Date of Birth:</label>
                    <form:input path="birthDate" tabindex="3"/>
                </p>
                <p id="buttons">
                    <input id="reset" type="reset" tabindex="4">
                    <input id="submit" type="submit" tabindex="5" value="Add Employee">
                </p>
            </fieldset>
        </form:form>
    
    </div>
</body>
</html>