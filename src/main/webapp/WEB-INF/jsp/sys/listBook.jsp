<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="/zking" %>
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
    <%@taglib prefix="z" uri="/zking" %>
    <title>书本添加</title>
</head>
<body>
    <h1>书本新增</h1>
    <f:form action="${ctx}/sys/book/listBook" method="post" modelAttribute="book">
        书名:<f:input path="bookName"></f:input>
        <input type="submit" value="查询"/>
    </f:form>
    <table width="100%" border="1">
        <tr>
            <td>书名ID</td>
            <td>书本名称</td>
            <td>书本价格</td>
            <td>操作</td>
        </tr>
        <c:forEach var="v" items="${bookList}">
            <tr>
                <td>${v.bookId}</td>
                <td>${v.bookName}</td>
                <td><fmt:formatNumber value="${v.price}"></fmt:formatNumber></td>
                <td>
                    <a href="${ctx}/sys/book/del?bookId=${v.bookId}">删除</a>
                    <a href="${ctx}/sys/book/edit?bookId=${v.bookId}">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <z:page pageBean="${pageBean}"/>
</body>
</html>
