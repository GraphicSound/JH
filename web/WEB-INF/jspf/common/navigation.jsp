<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Brand and toggle get grouped for better mobile display -->
<div class="navbar-header">
    <a class="navbar-brand" href="<c:url value="/" />">嘉华</a>
</div>

<!-- Collect the nav links, forms, and other content for toggling -->
<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
        <li class="index"><a href="<c:url value="/" />">首页</a></li>
        <li class="showTickets"><a href="<c:url value="/showTickets.action" />">在线订票</a></li>
    </ul>

    <c:choose>
        <c:when test="${sessionScope.user ne null}">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">用户中心 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">个人信息</a></li>
                        <li><a href="#">账户充值</a></li>
                        <li><a href="#">订单查询</a></li>
                        <li class="divider"></li>
                        <li><a href="<c:url value="/logout.action"/> ">退出</a></li>
                    </ul>
                </li>
            </ul>
        </c:when>
        <c:otherwise>
            <form class="navbar-form navbar-right" role="form" action="<c:url value="/login.action"/> " method="post">
                <div class="form-group">
                    <input type="text" name="username" placeholder="Email" class="form-control">
                </div>
                <div class="form-group">
                    <input type="password" name="password" placeholder="Password" class="form-control">
                </div>
                <button type="submit" class="btn btn-success">登陆</button>
            </form>
        </c:otherwise>
    </c:choose>
</div><!-- /.navbar-collapse -->

<script>
    $(function() {
        //
        var path = location.pathname.split("/")[2].split(".")[0];
        if("" == path) {
            $(".index").addClass("active");
        } else {
            $("." + path).addClass("active");
        }
    });
</script>
