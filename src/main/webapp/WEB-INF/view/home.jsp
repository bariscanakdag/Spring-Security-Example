<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="securtiy" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: p1352
  Date: 4/16/2019
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h2>Welcome to HomePage </h2>

<hr>
<p>
    User : <securtiy:authentication property="principal.username"/>
</p>
<p>
    Role : <securtiy:authentication property="principal.authorities"/>
</p>

<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout">
</form:form>
<hr>

<securtiy:authorize access="hasRole('MANAGER')">
    <p>
        <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
        (Only for LeaderShip)
    </p>
</securtiy:authorize>

<hr>

<securtiy:authorize access="hasRole('ADMIN')">
    <p>

        <a href="${pageContext.request.contextPath}/systems">Only for Adminisrator</a>
    </p>
</securtiy:authorize>

<hr>
</body>
</html>
