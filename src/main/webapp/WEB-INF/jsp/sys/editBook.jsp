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
    <title>书本修改</title>
</head>
<body>
    <h1>书本新增</h1>
    <f:form action="${ctx}/sys/book/update" method="post" modelAttribute="bk">
           <input type="hidden" name="bookId" value="${book1.bookId}"/>
        书名:<input type="bookName" name="bookName" value="${book1.bookName}"></input><br/>
        价格:<input type="price" name="price" value="${book1.price}"></input>
        <f:select path="categoryId">
            <f:options items="${categoryIds}"></f:options>
        </f:select>
        <input type="submit" value="提交"/>
    </f:form>

</body>
</html>
