<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lori Cheung
  Date: 2021/12/4
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>列出商品</title>
</head>
<body>
<fieldset>
    <legend>全部商品信息</legend>
<table>
<tr onmousemove="this.style.backgroundColor='white'" onmouseout="this.style.backgroundColor='#F5FAFE';">
    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">商品编号</td>
    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">商品名称</td>
    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">商品价格</td>
    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">商品库存</td>
    <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">商品图片</td>
<c:forEach items="${ps}" var="p">
    <tr onmousemove="this.style.backgroundColor='white'" onmouseout="this.style.backgroundColor='#F5FAFE';">
        <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="200">${p.pid }</td>
        <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="18%">${p.pname }</td>
        <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${p.pprice }</td>
        <td style="CURSOR: hand; HEIGHT: 22px" align="center" width="8%">${p.pallnum }</td>
        <td>
            <img src="${pageContext.request.contextPath}/pictures/${p.pid }.jpg" height="100" width="100">
        </td>
    </tr>
    <br>
</c:forEach>
</table>
</fieldset>
<fieldset>
    <legend>删除商品</legend>
<form action="${pageContext.request.contextPath}/DeleteProductServlet" method="post">
<table>
    <tr>
        <td>
            请输入要删除的商品编号：
        </td>
        <td>
            <input type="text" name="productid" value="${param.productid}">
        </td>
        <td>
            <input type="submit" value="确认">
        </td>
    </tr>
</table>
</form>
</fieldset>
<fieldset>
    <legend>修改商品</legend>
    <form action="${pageContext.request.contextPath}/EditProductServlet" method="post">
        <br>没有修改就照原样输入
        <br>

        <table>
            <tr>
                <td>
                    商品编号：
                </td>
                <td>
                    <input type="text" name="productid" value="${param.productid}">
                </td>
            </tr>
            <tr>
                <td>
                    商品名称：
                </td>
                <td>
                    <input type="text" name="productname" value="${param.productname}">
                </td>
            </tr>
            <tr>
                <td>
                    商品价格：
                </td>
                <td>
                    <input type="text" name="productprice" value="${param.productprice}">
                </td>
            </tr>
            <tr>
                <td>
                    商品库存：
                </td>
                <td>
                    <input type="text" name="productallnum" value="${param.productallnum}">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="确认">
                </td>
            </tr>
        </table>
    </form>
</fieldset>

</body>
</html>
