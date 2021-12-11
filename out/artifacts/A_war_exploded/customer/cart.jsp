<%@ page import="java.util.List" %>
<%@ page import="domain.Cart" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lori Cheung
  Date: 2021/12/5
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<fieldset>
    <legend>购物车信息</legend>

    <table>
        <tr onmousemove="this.style.backgroundColor='white'" onmouseout="this.style.backgroundColor='#F5FAFE';">
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">商品名称</td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">商品数量</td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">商品价格</td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">商品图片</td>

        <c:forEach items="${ps}" var="c">

            <tr onmousemove="this.style.backgroundColor='white'" onmouseout="this.style.backgroundColor='#F5FAFE';">
                <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">${c.c_pname }</td>
                <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">${c.cnum }</td>
                <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">${c.c_pprice }</td>
                <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
                    <img src="${pageContext.request.contextPath}/pictures/${c.c_pid}.jpg"
                         width="100" height="100">
                </td>
            <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">
                <form action="${pageContext.request.contextPath}/PurchaseServlet?ppid=${c.c_pid}&ccid=${c.cid}&uuid=<%=request.getAttribute("uid")%>" method="post">
                <%
                        request.getSession().setAttribute("uid",request.getAttribute("uid"));
                        request.getSession().setAttribute("pid",request.getAttribute("pid"));
                        request.getSession().setAttribute("cid",request.getAttribute("cid"));
                %>

                <input type="submit" value="购买">
                </form>
            </tr>
            <br>
        </c:forEach>
    </table>
</fieldset>
</body>
</html>
