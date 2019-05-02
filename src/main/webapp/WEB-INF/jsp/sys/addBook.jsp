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
    <h1>书本新增</h1>
    <f:form action="${ctx}/sys/book/add3" method="post" modelAttribute="book">
        书名:<f:input path="bookName" ></f:input><f:errors path="bookName" cssClass="err"/> <br/>
        价格:<f:input path="price"></f:input><f:errors path="price" cssClass="err"/><br/>
        <f:select path="categoryId">
            <f:options items="${categoryIds}"></f:options>
        </f:select>
        <input type="submit" value="提交"/>
    </f:form>

</body>
</html>
