<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/23 0023
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
    <title>书本添加</title>
</head>
<body>
    <h1>文件上传</h1>
    <c:if test="${null!=sessionScope.msg}">
        <div>
            <h2>${sessionScope.msg}</h2>
        </div>
        <c:remove var="msg" scope="session"></c:remove>

    </c:if>

    <f:form action="${ctx}/sys/file/upload" method="post" modelAttribute="fileVo" enctype="multipart/form-data">
        <input type="file" name="img">
        <input type="submit" value="提交"/>
    </f:form>

</body>
</html>
