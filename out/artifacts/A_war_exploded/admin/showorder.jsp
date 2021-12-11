<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lori Cheung
  Date: 2021/12/8
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单查询</title>
</head>
<body>
<fieldset>
    <legend>全部订单信息</legend>
    <table>
        <tr onmousemove="this.style.backgroundColor='white'" onmouseout="this.style.backgroundColor='#F5FAFE';">
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">订单编号</td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">顾客编号</td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">商品编号</td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">总价格</td>

            <c:forEach items="${ps}" var="o">
        <tr onmousemove="this.style.backgroundColor='white'" onmouseout="this.style.backgroundColor='#F5FAFE';">
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">${o.oid }</td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">${o.o_uid }</td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${o.o_pid }</td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${o.omoney }</td>

        </tr>
        <br>
        </c:forEach>
    </table>
</fieldset>
<fieldset>
    <legend>查询某一用户订单</legend>
<form action="${pageContext.request.contextPath}/SpecificOrderServlet" method="post">
    <table>
        <tr>
            输入用户id:<input type="text" value="${param.uid}" name="uid">
            <input type="submit" value="确认">
        </tr>
    </table>
</form>
</fieldset>
<fieldset>
    <legend>查询某一商品销售情况</legend>

    <table>
        <form action="${pageContext.request.contextPath}/SpecificOrderServlet" method="post">
        <tr>
            输入商品id:
            <input type="text" value="${param.pid}" name="pid">
            <input type="submit" value="确认">
        </tr>
        </form>
    </table>

</fieldset>
</body>
</html>
