<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lori Cheung
  Date: 2021/12/8
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>精准查单</title>
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
</body>
</html>
