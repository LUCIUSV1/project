﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<section>
    <div class="right">
        <img class="wColck" src="${pageContext.request.contextPath }/images/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>${userSession.doctorName}</h2>
            <p>欢迎来到保亿辰旭分诊排队叫号系统!</p>
        </div>
    </div>
</section>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>