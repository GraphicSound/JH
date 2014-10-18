<%--
  Created by IntelliJ IDEA.
  User: yu
  Date: 10/12/14
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Carousel================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <img src="<c:url value="/images/Guardians-of-the-Galaxy-End-Credits-Scene-Explained.jpg"/> " alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>银河护卫队</h1>
                    <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">立即购票</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="<c:url value="/images/xinhualufang.jpg"/> " alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>心花路放</h1>
                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">立即购票</a></p>
                </div>
            </div>
        </div>
        <div class="item">
            <img src="<c:url value="/images/Star-Treck.jpg"/> " alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>星际迷航</h1>
                    <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    <p><a class="btn btn-lg btn-primary" href="#" role="button">立即购票</a></p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
</div><!-- /.carousel -->
