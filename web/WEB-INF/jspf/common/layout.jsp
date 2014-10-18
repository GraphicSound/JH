<%--
  Created by IntelliJ IDEA.
  User: yu
  Date: 9/24/14
  Time: 7:59 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>

<html>
<head>
    <title>${pageTitle}</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="iyuhao.com">

    <link href="<c:url value="/css/style.css"/>" rel="stylesheet" type="text/css" />

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="<c:url value="/bootstrap/bootstrap.min.css"/> ">

    <!-- Optional theme -->
    <link rel="stylesheet" href="<c:url value="/bootstrap/bootstrap-theme.min.css"/> ">

    <!-- Bootstrap core JavaScript
        ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<c:url value="/jquery/jquery-2.1.1.js"/> "></script>
    <script src="<c:url value="/jquery/jquery.cookie.js"/> "></script>
    <script src="<c:url value="/js/json2.js"/> "></script>
    <script src="<c:url value="/js/jiahua.js"/> "></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="<c:url value="/bootstrap/bootstrap.min.js"/> "></script>
</head>

<body>
<div class="body-container">
<div class="header">
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <jsp:include page="/WEB-INF/jspf/common/navigation.jsp" />
        </div>
    </nav>
</div>

<div class="main">
    <c:if test="${not empty sidebar}">
        <div class="sidebar">
            <jsp:include page="/WEB-INF/jspf/${sidebar}.jsp" />
        </div>
    </c:if>
    <div class="content">
        <jsp:include page="/WEB-INF/jspf/${mainContent}.jsp" />
    </div>
</div>

<div class="footer">
    <div class="container">
        <%@include file="/WEB-INF/jspf/common/footer.jsp" %>
    </div>
</div>
</div>
</body>
</html>