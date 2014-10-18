<%--
  Created by IntelliJ IDEA.
  User: yu
  Date: 10/12/14
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="register">
    <h1>注册</h1>
    <form method="post" action="<c:url value="/"/>">
    <p><input type="text" name="username" value="" placeholder="用户名"></p>
    <p><input type="password" name="password" value="" placeholder="密码"></p>
    <p><input type="password" name="confirmPassword" value="" placeholder="确认密码"></p>
    <p><input type="text" name="realName" value="" placeholder="真实姓名"></p>
    <p><input type="text" name="idNumber" value="" placeholder="身份证号"></p>
    <p><input type="text" name="telno" value="" placeholder="联系电话"></p>

    <p class="submit"><input type="submit" name="commit" value="Done"></p>
    </form>
</div>
