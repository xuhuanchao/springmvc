<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Download Page</title>
    
    <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
    <div id="global">
        <form:form commandName="login" action="login" method="post">
            <fieldset>
                <legend>Login</legend>
                <p>
                    <label for="userName">User Name: </label>
                    <form:input id="userName" path="userName" cssErrorClass="error"/>
                </p>
                <p>
                    <label for="password">Password: </label>
                    <form:input id="password" path="password" cssErrorClass="error"/>
                </p>
                <p id="buttons">
                    <input id="reset" type="reset" tabindex="4" />
                    <input id="submit" type="submit" tabindex="5" value="Login" />
                </p>
            </fieldset>
        </form:form>
    
    </div>
</body>
</html>