<%@ page import="domain.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lori Cheung
  Date: 2021/12/1
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物页面</title>
</head>
<body>

<table>
    <tr>
        <td>
            欢迎登录:<%=request.getAttribute("username")%>

        </td>
        <td>
            <%=request.getAttribute("logout")%>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/CartServlet?uid=<%=request.getAttribute("uid")%>">
                <input type="button" value="购物车"></a>
        </td>
        <td>
            <a href="${pageContext.request.contextPath}/RecordServlet?uid=<%=request.getAttribute("uid")%>">
                <input type="button" value="浏览记录"></a>
        </td>
    </tr>

</table>
<br>
<table>
    <form action="${pageContext.request.contextPath}/SelectNameServlet" method="post">
    <tr>
        <%
        User user=new User();
        user= (User) request.getAttribute("user");
        %>
        输入商品名称查询：<input type="text" name="pname" value="${param.pname}">
        <input type="submit" value="查询">
    </tr>
    </form>
</table>
<c:forEach items="${ps}" var="p">
    <table>
    <tr>
        <img src="${pageContext.request.contextPath}/pictures/${p.pid }.jpg" height="300" width="300">
    </tr>
    <tr >
        <td >编号：${p.pid } </td>
        <td >名称：${p.pname }</td>
        <td >价格：${p.pprice }</td>
        <td >库存：${p.pallnum }</td>

        <td>
            <a href="${pageContext.request.contextPath}/DetailServlet?pid=${p.pid }&pname=${p.pname }&pprice=${p.pprice }&pallnum=${p.pallnum }">
                <input type="button" value="详情">
            </a>
        </td>

    </tr>
    <br>
    </table>
</c:forEach>

</body>
</html>
