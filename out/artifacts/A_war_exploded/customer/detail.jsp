<%--
  Created by IntelliJ IDEA.
  User: Lori Cheung
  Date: 2021/12/5
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>详情</title>
</head>
<body>
<table>
    <td>
        <tr>
            欢迎登录:<%=request.getAttribute("username")%>
            <%=request.getAttribute("logout")%>

        </tr>
    </td>
</table>

<%
    String pid=request.getParameter("pid");
    String pname=request.getParameter("pname");
    String pprice=request.getParameter("pprice");
    String pallnum=request.getParameter("pallnum");
%>
<img src="${pageContext.request.contextPath}/pictures/<%=pid%>.jpg">
<br>
名称：<%=pname%>
<br>
价格：<%=pprice%>
<br>
库存：<%=pallnum%>
<br>

<form action="${pageContext.request.contextPath}/AddCartServlet" method="post">

    <%
        request.getSession().setAttribute("uid",request.getAttribute("uid"));
        request.getSession().setAttribute("pid",pid);
        request.getSession().setAttribute("pprice",pprice);
    %>
    选择购买数量<input type="text" name="cnum" value="1">
    <input type="submit" value="加入购物车">

</form>
</body>
</html>
