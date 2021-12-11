<%--
  Created by IntelliJ IDEA.
  User: 28358
  Date: 2021/12/3
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加商品</title>
</head>
<body>
<fieldset>
    <legend>增加商品</legend>
    <form action="../AddProductServlet" method="post" enctype="multipart/form-data">
        <table>
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
                <td align="center" bgColor="#f5fafe" class="ta_01">商品图片：</td>
                <td class="ta_01" bgColor="#ffffff" colspan="3">
                    <input type="file" name="myfile" size="30" value="" />
                </td>
            </tr>
            <tr>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>
