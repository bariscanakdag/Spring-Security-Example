<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: p1352
  Date: 4/16/2019
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Leaders Page</title>
</head>
<body>

<h2>Welcome to Leader Page</h2>

<hr>
<p>
    User : <security:authentication property="principal.username"/>
</p>
<p>
    Role : <security:authentication property="principal.authorities"/>
</p>
<p>
    <a href="${pageContext.request.contextPath}/">Back to HomePage</a>
</p>
</body>
</html>
