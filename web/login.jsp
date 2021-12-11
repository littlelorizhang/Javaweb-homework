<%--
  Created by IntelliJ IDEA.
  User: Lori Cheung
  Date: 2021/11/30
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<fieldset>
    <legend>用户登陆</legend>
    <form action="LoginServlet" method="post">
        <table cellpadding="2" align="center">
            <tr>
                <td align="right">用户名:</td>
                <td>
                    <input type="text" name="username" value="${param.username}">
                </td>
            </tr>
            <tr>
                <td align="right">密码:</td>
                <td>
                    <input type="password" name="userpassword" value="${param.userpassword}">
                </td>
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
