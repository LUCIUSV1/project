
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        hello! ${hello}<br/>
        req! ${req}<br/>
        session:${sessionScope.sess}<br/>
        model:${string}<br/>
        map:${map}
<form action="test.do" method="post">
        <div>请输入userCode:<input type="text" name="userCode" value=""/></div>
        <div><input type="submit" value="提交"></div>
<%--http://localhost:8080/hello.jsp--%>
</form>
</body>
</html>
