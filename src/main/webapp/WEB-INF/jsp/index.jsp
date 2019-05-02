<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/23 0023
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title><t:message code="label.title"></t:message> </title>
</head>
<body>
<div>
    <h1><t:message code="label.title"></t:message></h1>
    <div>
        <a href="${ctx}/i18n?locale=zh">中文</a>
        <a href="${ctx}/i18n?locale=en">英文</a>
    </div>

    <a href="${ctx}/sys/book/toAdd"><t:message code="label.msg1"></t:message></a>
    <a href="${ctx}/sys/book/listBook"><t:message code="label.msg2"></t:message></a><br/>

    <a href="${ctx}/sys/file/toUpload">文件上传</a>


</div>


</body>
</html>
