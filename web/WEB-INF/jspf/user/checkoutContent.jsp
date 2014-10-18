<%--
  Created by IntelliJ IDEA.
  User: yu
  Date: 10/15/14
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="<c:url value="/checkoutAdmitted.action"/> " method="post">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>影片</th>
            <th>时长(分钟)</th>
            <th>上映时间</th>
            <th>放映厅</th>
            <th>价格(元)</th>
            <th>数量</th>
        </tr>
        </thead>

        <c:forEach items="${sessionScope.orderLists}" var="orderList" varStatus="status1">
            <c:forEach items="${sessionScope.arrangements}" var="arrangement" varStatus="status2">
                <c:if test="${arrangement.id eq orderList.arrangementId}">
                    <tr>
                        <c:forEach items="${sessionScope.movies}" var="movie" varStatus="status3">
                            <c:if test="${arrangement.movieId eq movie.id}">
                                <td>${movie.title}</td>
                                <td>${movie.duration}</td>
                            </c:if>
                        </c:forEach>
                        <td>${arrangement.showTime}</td>
                        <td>${arrangement.theater}</td>
                        <td>${arrangement.price}</td>
                        <td>${orderList.quantity}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </c:forEach>
    </table>

    <div class="contentCenterAlign">
        <p>您总共需要支付${sessionScope.totalPrice}元</p>
        <button type="submit" class="btn btn-danger">确认支付</button>
    </div>
</form>
