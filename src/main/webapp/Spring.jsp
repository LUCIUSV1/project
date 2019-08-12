<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/12/6
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fm" uri="http://www.springframework.org/tags/form" %>
<jsp:useBean id="user" class="com.entity.User" scope="request"/>
<html>
<head>
    <title>Title</title>
    <style>
        span{
            color: red;
            font-size: 36px;
        }
    </style>
</head>
<body>
<fm:form action="${pageContext.request.contextPath}/user/TestUser" method="post" modelAttribute="user">
    用户名：<fm:input path="userName"/><fm:errors path="userName"/>
    密码：<fm:password path="userPassword"/><fm:errors path="userPassword"/>
    <input type="submit" value="1"/>
</fm:form>
</body>
</html>
