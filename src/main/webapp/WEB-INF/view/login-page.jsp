<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: p1352
  Date: 4/16/2019
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>

    <style>
        .failed{
            color: red;
        }
    </style>

</head>
<body>
<h3>Login Page</h3>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="post">
    <c:if test="${param.error != null}">

        <i class="failed">Failed to login. Check this username and password</i>

    </c:if>
    <p>
        User Name : <input type="text" name="username"/>
    </p>
    <p>
        Password : <input type="password" name="password">
    </p>

    <input type="submit" value="Login">


</form:form>
</body>
</html>
