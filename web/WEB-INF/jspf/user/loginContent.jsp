<%--
  Created by IntelliJ IDEA.
  User: yu
  Date: 10/16/14
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form class="form-signin" role="form" action="<c:url value="/login.action"/> " method="post">
    <h2 class="form-signin-heading">请您登录</h2>
    <input name="username" type="email" class="form-control" placeholder="Email address" required autofocus>
    <input name="password" type="password" class="form-control" placeholder="Password" required>
    <label class="checkbox">
        <input type="checkbox" value="remember-me"> 记住我
    </label>
    <button class="btn btn-lg btn-success btn-block" type="submit">登陆</button>
</form>
