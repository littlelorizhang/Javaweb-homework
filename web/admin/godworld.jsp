<%--
  Created by IntelliJ IDEA.
  User: Lori Cheung
  Date: 2021/12/2
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员界面</title>
</head>
<body>
<tr>
    <td>
        <a href="${pageContext.request.contextPath}/admin/addproduct.jsp"><input type="button" value="上架商品"></a>
    </td>
    <form action="${pageContext.request.contextPath}/ListProductServlet" method="post" >
    <td>
        <a href="${pageContext.request.contextPath}/admin/listproduct.jsp"><input type="submit" value="查询商品"></a>
    </td>
    </form >
    <form action="${pageContext.request.contextPath}/ShowOrderServlet" method="post">
        <td>
            <a href="${pageContext.request.contextPath}/admin/showorder.jsp"><input type="submit" value="查询订单"></a>
        </td>
    </form>


</tr>
<form action="${pageContext.request.contextPath}/RecordServlet" method="post">
<tr>
    <td>
        输入用户id:<input type="text" value="${param.uid}" name="uid">
        <input type="submit" value="查询浏览记录">
    </td>
</tr>
</form>
</body>
</html>
