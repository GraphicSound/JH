<%--
  Created by IntelliJ IDEA.
  User: yu
  Date: 10/12/14
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-striped ticketsTable">
    <c:forEach items="${sessionScope.movies}" var="movie" varStatus="movieStatus">
        <tr>
            <td class="movie-description">
                <h4>${movie.title}</h4>
                <img src="<c:url value="/images/${movie.title}.jpg" />"/>
                <p>${movie.desc}</p>
            </td>
            <td>
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>时长(分钟)</th>
                            <th>上映时间</th>
                            <th>放映厅</th>
                            <th>剩余票数</th>
                            <th>价格(元)</th>
                            <th>数量</th>
                            <th>订票</th>
                        </tr>
                    </thead>
                    <c:forEach items="${sessionScope.arrangements}" var="arrangement" varStatus="arrangementStatus">
                        <c:if test="${movie.id eq arrangement.movieId}">
                            <tr>
                                <td>${movie.duration}</td>
                                <td>${arrangement.showTime}</td>
                                <td>${arrangement.theater}</td>
                                <td>${arrangement.balance}</td>
                                <td>${arrangement.price}</td>
                                <td>
                                    <button type="button" class="btn btn-xs btn-danger" onclick="decrement(this)">-</button>
                                    <input id="${arrangement.id}" onfocus="this.oldvalue = this.value" onchange="inputChanged(this)" value="0"/>
                                    <button type="button" class="btn btn-xs btn-success" onclick="increment(this)">+</button>
                                </td>
                                <td>
                                    <button type="button" class="btn btn-xs btn-success" onclick="writeCartCookie('${movie.title}', '${arrangement.id}', '${arrangement.showTime}', '${arrangement.theater}', '${arrangement.price}', this)">订票</button>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </c:forEach>
</table>

<script>

    // 加减数字
    function increment(sender) {
        $(sender).prev().val(function(i, oldval) {
            return ++oldval;
        });
    }

    function decrement(sender) {
        $(sender).next().val(function(i, oldval) {
            if(0 == oldval) {
                return 0;
            }
            return --oldval;
        });
    }

    function inputChanged(jsThis) {
        var sender = $(jsThis);
        var count = sender.val();

        if(!(count >= 0 && count < 1000)) {
            // 还原之前的值
            sender.val(jsThis.oldvalue);
        }
    }
</script>
