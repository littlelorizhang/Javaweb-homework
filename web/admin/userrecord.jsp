<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lori Cheung
  Date: 2021/12/9
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户浏览记录</title>
</head>
<body>
<fieldset>
    <legend>浏览信息</legend>
    <table>
        <tr onmousemove="this.style.backgroundColor='white'" onmouseout="this.style.backgroundColor='#F5FAFE';">

            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">商品名称</td>
<c:forEach items="${ps}" var="p">
        <tr onmousemove="this.style.backgroundColor='white'" onmouseout="this.style.backgroundColor='#F5FAFE';">

            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">${p.r_pname }</td>

        </tr>
        <br>
</c:forEach>
    </table>
</fieldset>
</body>
</html>
