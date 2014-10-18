<%--
  Created by IntelliJ IDEA.
  User: yu
  Date: 9/24/14
  Time: 8:56 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" scope="request">嘉华国际电影城</c:set>
<c:set var="navigation" scope="request">common/navigation</c:set>
<c:set var="mainContent" scope="request">user/showTicketsContent</c:set>

<jsp:include page="/WEB-INF/jspf/common/layout.jsp"/>