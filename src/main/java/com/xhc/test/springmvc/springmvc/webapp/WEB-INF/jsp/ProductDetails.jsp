<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Save Product</title>
</head>
<body>
    <div id="global">
        <h4>The product has been saved.</h4>
        <p>
            <h5>Details:</h5>
            Product Name: ${product.name}<br/>
            Description: ${product.description }<br/>
            Price: ${product.price }<br/>
            Product Date : ${product.productionDate }
        </p>
    </div>
</body>
</html>