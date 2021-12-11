<%--
  Created by IntelliJ IDEA.
  User: Lori Cheung
  Date: 2021/11/26
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript">
        function changeImage() {
            // 改变验证码图片中的文字
            document.getElementById("img").src = "${pageContext.request.contextPath}/CheckServlet?time="
                + new Date().getTime();
        }
    </script>
</head>
<body>
<fieldset>
    <legend>注册新用户</legend>
    <form action="${pageContext.request.contextPath}/RegisterServlet?method=add" method="post">
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
                    <input type="text" name="userpassword" value="${param.userpassword}">
                </td>
            </tr>
            <tr>
                <td align="right">邮箱:</td>
                <td>
                    <input type="text" name="useremail" value="${param.useremail}">
                </td>
            </tr>
            <tr>
                <td align="right">验证码:</td>
                <td>
                    <input type="text" name="checknum">
                </td>
            </tr>
            <tr>
                <td style="text-align: right; width: 20%;">&nbsp;</td>
                <td rowspan="2" style="width: 50%">
                    <img src="${pageContext.request.contextPath}/CheckServlet" width="180"
                         height="30" class="textinput" style="height: 30px;" id="img" />&nbsp;&nbsp;
                    <a href="javascript:void(0);" onclick="changeImage()">看不清换一张</a>
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
