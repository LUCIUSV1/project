<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>	
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta HTTP-EQUIV="pragma" CONTENT="no-cache">

    <meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">

    <meta HTTP-EQUIV="expires" CONTENT="0">
    <title>保亿辰旭分诊排队叫号系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" />
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/public.css" />
</head>
<%
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control","no-store");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
    %>
<body>
<!--头部-->
    <header class="publicHeader">
        <h1>保亿辰旭分诊排队叫号系统</h1>
        <div class="publicHeaderR">
            <input type="hidden" name="getUserName" value="${userSession.doctorName}">

            <p><span style="color: #fff21b"> ${userSession.doctorName }</span> , 欢迎你！</p>
            <a href="${pageContext.request.contextPath }/user/logout.do">退出</a>
        </div>
    </header>
<!--时间-->
    <section class="publicTime">
        <span id="time">
            <%
            Date date =new Date();
            request.setAttribute("noe",date);%>
            <fmt:formatDate value="${noe}" pattern="yyyy年MM月dd日 HH:mm:ss E"/>
        </span>
        <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
    </section>
 <!--主体内容-->
 <section class="publicMian ">
     <div class="left">
         <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
         <nav>
             <ul class="list">
                 <li ><a href="${pageContext.request.contextPath }/pat/getPat">当前列表</a></li>
              <li><a href="${pageContext.request.contextPath }/pro/provider">全部列表</a></li>
<%--              <li><a href="${pageContext.request.contextPath }/user/queryUserList">用户管理</a></li>--%>
              <li><a href="${pageContext.request.contextPath }/user/pwdModify">密码修改</a></li>
              <li><a href="${pageContext.request.contextPath }/user/logout.do">退出系统</a></li>
             </ul>
         </nav>
     </div>
     <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath }"/>
     <input type="hidden" id="referer" name="referer" value="<%=request.getHeader("Referer")%>"/>
 </section>
</body>
