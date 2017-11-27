<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>你调用到了spring controller，并成功返回了页面！</h2>
    <p>
        你传递了参数param的值是：${param.param} ， controller修改后的param值是：${requestScope.param}
    </p>
    
    <p>
        <c:out value="$ {test}"/><br/>
        <c:out value="$ {requestScope.test}"/><br/>  
        <c:out value="< %request.getAttribute('test') %> " /><br/>
                可以取出request.setAttribute("test", "123");中的值<br/>
    </p>
    <p>
        \${param.test}<br/>
        <c:out value="< %=request.getParameter('test')"/><br/>
                可以取出URL的参数
    </p>
    <form action="test1" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="name">Product Name:</label>
                <input type="text" id="name" name="name" tabindex="1"/>
            </p>
            <p>
                <label for="description">Descrption:</label>
                <input type="text" id="description" name="description" tabindex="2"/>
            </p>
            <p>
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" tabindex="3"/>
            </p>
            <p id="buttons">
                <input id="reset" type="reset" tabindex="4"/>
                <input id="submit" type="submit" tabindex="5" value="Add Product"/>
            </p>
        </fieldset>
    </form>
    <p>
        表单提交到后台使用@ModelAttribute注解参数的controller，将参数保存到Model中<br/>
        从Model中取出的Product对象：${product2 }
    </p>
    <p>
        通过@ModelAttribute注解的返回Product的方法，生成默认Product添加到Model中的Product对象：${product }<br/>
        通过@ModelAttribute注解无返回值的方法，生成默认Product添加到Model中的Product对象：${default2 }
    </p>
</body>
</html>