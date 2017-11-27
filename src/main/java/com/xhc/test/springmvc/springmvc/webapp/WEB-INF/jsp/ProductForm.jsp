<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- <style type="text/css">@import url(/css/main.css)</style> -->
    <style type="text/css">@import url(<c:url value="/css/main.css"/>);</style>
    <title>Add Product Form</title>
</head>
<body>
    <div id="global">

        <form:form commandName="product" action="product_save" method="post">
            <fieldset>
                <legend>Add a product</legend>
                <p>
                    <label for="name">Product Name:</label>
                    <form:input id="name" path="name" tabindex="1"/>
                    <form:errors path="name"/>
                </p>
                <p>
                    <label for="description">Descrption:</label>
                    <form:input  id="description" path="description" tabindex="2"/>
                    <form:errors path="description"/>
                </p>
                <p>
                    <label for="price">Price:</label>
                    <form:input  id="price" path="price" tabindex="3"/>
                    <form:errors path="price"/>
                </p>
                <p>
                    <label for="price">productionDate:</label>
                    <form:input type="text" id="productionDate" path="productionDate" tabindex="4"/>
                    <form:errors path="productionDate"/>
                </p>
                <p id="buttons">
                    <input id="reset" type="reset" tabindex="5"/>
                    <input id="submit" type="submit" tabindex="6" value="Add Product"/>
                </p>
            </fieldset>
        </form:form>
    </div>
</body>
</html>