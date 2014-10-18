<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<style>

    .order-list ul {
        margin-top: 0px;
        margin-bottom: 0px;
    }

    ul,ol {
        padding-left: 0;
        list-style-type: none;
    }

    .fr {
        float: right;
    }

    .fl {
        float: left;
    }

    .hidden {
        display: none;
    }

    .unvisialbe {
        visibility: hidden;
    }

    .clear {
        clear: both;
    }

    .clearfix:after {
        visibility: hidden;
        display: block;
        font-size: 0;
        content: " ";
        clear: both;
        height: 0;
    }

    .clearfix {
        zoom: 1
    }

    .icon {
        background-image: url(http://xs01.meituan.net/waimai_web/img/sprite/icons_543bf40d.png);
        _background-image: url(http://xs01.meituan.net/waimai_web/img/sprite/_icons_543bf40d.png);
        background-repeat: no-repeat;
        image-rendering: -webkit-optimize-contrast;
        display: inline-block;
    }

    .i-shopping-cart {
        width: 25px;
        height: 20px;
        background-position: -60px -198px;
    }

    .shopping-cart {
        position: fixed;
        bottom: 0;
        left: 50%;
        margin-left: 230px;
        width: 290px;
        z-index: 100;
        font-size: 14px;
        _position: absolute;
        _top: expression(eval(document.documentElement.scrollTop + document.documentElement.clientHeight - 40));
    }

    .shopping-cart .clickable-footer {
        background-color: #333333;
        cursor: pointer;
        z-index: 1;
        position: relative;
    }

    .shopping-cart .logo {
        width: 42px;
        height: 40px;
        background-color: #FF6900;
        padding-top: 10px;
        padding-left: 8px;
    }

    .shopping-cart .brief-order {
        display: none;
        color: #AAAAAA;
        padding-top: 12px;
        padding-left: 15px;
    }

    .shopping-cart .brief-order span {
        margin-right: 5px;
    }

    .shopping-cart .go-pay {
        height: 31px;
        background-color: #8FC31F;
        text-align: center;
        line-height: 31px;
        color: #FFFFFF;
        margin-top: 5px;
        margin-right: 5px;
        font-weight: bold;
        padding: 0 15px;
        display: none;
        border: 0;
        cursor: pointer;
    }

    .shopping-cart .ready-pay {
        height: 31px;
        background-color: #E5E5E5;
        display: inline-block;
        text-align: center;
        line-height: 31px;
        color: #A0A0A0;
        margin-top: 5px;
        margin-right: 5px;
        font-weight: bold;
        padding: 0 15px;
    }

    .shopping-cart .order-list {
        width: 289px;
        background-color: #FFFFFF;
        border-right: 1px solid #DCDCDC;
        position: absolute;
        top: 0;
        box-shadow: 0 -1px 9px #CCC;
        -moz-box-shadow: 0 -1px 9px #CCC;
        -webkit-box-shadow: 0 -1px 9px #CCC;
        -ms-box-shadow: 0 -1px 9px #CCC;
        -o-box-shadow: 0 -1px 9px #CCC;
    }

    .shopping-cart .title {
        color: #898989;
        background-color: #F5F5F5;
        border-top: 3px solid #FF6900;
        height: 30px;
        line-height: 27px;
        padding-left: 8px;
        padding-right: 19px;
        font-size: 12px;
    }

    .shopping-cart .title .ti-price {
        margin-left: 47px;
        white-space: nowrap;
    }

    .shopping-cart .title .dishes {
        width: 164px;
        white-space: nowrap;
    }

    .shopping-cart .dishes .clear-cart {
        margin-left: 3px;
        color: #FF6900;
    }

    .shopping-cart ul li {
        height: 49px;
        border-bottom: 1px solid #E5E5E5;
        padding-left: 10px;
    }

    .shopping-cart .na {
        line-height: 49px;
        height: 49px;
        width: 145px;
    }

    .shopping-cart .pri {
        line-height: 49px;
        width: 52px;
        text-align: right;
    }

    .shopping-cart .modify {
        padding-top: 16px;
        font-size: 12px;
    }

    .shopping-cart .modify a {
        width: 16px;
        height: 16px;
        border: 1px solid #E5E5E5;
        display: inline-block;
        letter-spacing: 0;
        color: #BFBFBF;
        font-weight: bold;
        text-align: center;
    }

    .shopping-cart .modify input {
        width: 30px;
        display: inline-block;
        height: 16px;
        _height: 17px;
        padding: 0 3px;
        line-height: 16px;
        border-left: 0;
        border-right: 0;
        border-color: #E5E5E5;
        text-align: center;
    }

    .shopping-cart .disabled-food .modify input,.shopping-cart .discount-food .modify input {
        border: 1px solid #E5E5E5;
    }

    .shopping-cart .disabled-food a.minus,.shopping-cart .discount-food a.minus,.shopping-cart .disabled-food a.plus,.shopping-cart .discount-food a.plus {
        visibility: hidden;
    }

    .shopping-cart .total {
        height: 49px;
        text-align: right;
        padding-top: 13px;
        padding-right: 25px;
    }

    .shopping-cart .total span {
        margin: 0 3px;
        color: #FF6900;
    }

    .shopping-cart .total span.bill {
        font-size: 16px;
        font-weight: bold;
        margin-right: 0;
        color: #FF6900;
    }

    .shopping-cart .other-charge,.shopping-cart .privilege {
        border-bottom: 1px solid #E5E5E5;
        padding: 10px 25px 15px 10px;
    }

    .shopping-cart .privilege .clearfix,.shopping-cart .other-charge .clearfix {
        padding-top: 3px;
    }
</style>

<c:if test="${pageContext.request.requestURI eq '/JH/WEB-INF/jspf/user/showTickets.jsp'}">
    <div class="shopping-cart clearfix">
        <form action="<c:url value='/checkout.action'/> " method="post">
            <div class="order-list">
                <div class="title">
                    <span class="fl dishes">影片<a href="javascript:;" class="clear-cart" onclick="clearCart()">[清空]</a></span>
                    <span class="fl">票数</span>
                    <span class="fl ti-price">价格</span>
                </div>

                <ul style="height: auto; overflow: visible;">
                </ul>

                <div class="privilege hidden">
                </div>
                <div class="total">共<span class="totalnumber">0</span>张票，总计￥<span class="bill">0</span></div>
            </div>

            <div class="clickable-footer clearfix">
                <div class="logo fl"><i class="icon i-shopping-cart"></i></div>
                <div class="brief-order fl">
                    <span class="count"></span>
                    <span class="price"></span>
                </div>
                <div class="fr">
                    <a class="ready-pay borderradius-2" href="javascript:;"><span data-left="20" class="margintominprice"></span></a>
                    <input class="go-pay borderradius-2" type="submit" value="去支付" />
                    <input type="hidden" value="" class="order-data" name="shop_cart" />
                </div>
            </div>
        </form>
    </div>
</c:if>

<div class="text-muted">
    &copy; 嘉华国际电影城, 2008 - <%= java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)%>
</div>

<script>

    $(function() {
    });

    // 页面加载完之后就刷新一下购物车
    reloadCart(getCartCookie());

    // 绑定事件
    // 实现点击购物车，列表的隐藏和显示
    $(".shopping-cart .clickable-footer").click(function() {
        animateCart(1);
    });
    // 虽然绑定了，还是需要触发一下，这样页面加载完列表就能展开（如果有商品的话）
    animateCart(1);

    function getCartCookie() {
        // 先从cookie读取数据，没有json字符串的话，创建一个【】
        var jsonCookieData = $.cookie("cart");
        if(jsonCookieData == null) {
            alert("cookie cart null");
            jsonCookieData = "[]";
        }
        return JSON.parse(jsonCookieData);
    }

    function writeCartCookie(title, arrangementId, showTime, theater, price, sender) {
        var quantity = $('#' + arrangementId).val();
        // 将input重置为0
        $('#' + arrangementId).val(0);
        var jsonData = getCartCookie();

        // 先检测一下原来有没有相同的票，有的话直接更新
        // 不能在数组遍历的时候对其进行元素删除操作，也不能进行增加，因为增加后还会被遍历到(但是会造成死循环啊！)
        var isExist = 0;
        var index = 0;
        var jsonItem;
        $.each(jsonData, function(i, item) {
            if(item.arrangementId == arrangementId) {
                isExist = 1;
                index = i;
                jsonItem = item;
                jsonItem.quantity = parseInt(quantity) + parseInt(item.quantity);
                // return; // 为什么这里不能用！！！
            }
        });

        // 如果不存在重复票，再添加
        if(1 == isExist) {
            jsonData.splice(index, 1);
            // 这样修改了的能排到最前面
            jsonData.push(jsonItem);
        } else {
            var arrangement = {"title" : title, "arrangementId" : arrangementId, "showTime" : showTime, "theater" : theater, "price" : price, "quantity" : quantity};
            jsonData.push(arrangement);
        }
        $.cookie("cart", JSON.stringify(jsonData), { path: '/', expires: 30 });

        // 更新html
        reloadCart(jsonData);

        // 展开列表，如果已经展开，参数0使不关闭
        animateCart(0);
    }

    function reloadCart(jData) {

        // 有可能jData为空，先进行判断
        if (0 != jData.length) {
            // 前后交换一下顺序，这样最后提交的票放在最下面
            // jData = jData.reverse();
        }

        // 首先清空显示，不然会有重复
        var shoppingCartUl = $(".shopping-cart ul");
        shoppingCartUl.empty();

        var totalNumber = 0;
        var bill = 0.0;
        $.each(jData, function(i, item) {
            totalNumber += parseInt(item.quantity);
            bill += parseFloat(item.price) * parseInt(item.quantity);

            shoppingCartUl.prepend(
                "<li class='clearfix'>" +
                    "<div class='fl na' style='font-size: 9px'>" + item.title + "(" + item.theater + ")" + "</div>" +
                "<div class='fl modify clearfix'>" +
                    "<a href='javascript:;' onclick='decrementCart(" + item.arrangementId + ", this)' class='fl minus'>-</a>" +
                    "<input type='text' onfocus='this.oldvalue = this.value' onchange='cartInputChanged(this)' class='fl txt-count' id='" + item.arrangementId + "' value='" + item.quantity + "'>" +
                    "<a href='javascript:;' onclick='incrementCart(" + item.arrangementId + ", this)' class='fl plus'>+</a>" +
                "</div>" +
                "<div class='fl pri'><span>¥" + (parseFloat(item.price) * parseInt(item.quantity)) + "</span></div>" +
                "</li>"
            );
        });

        // 如果放在jquery默认函数里面，怎新生成的li就没有绑定事件，，，而且事件不能多次绑定！！！
        // 购物车input绑定事件
        // $(".txt-count").change(function(event) {
        //     inputChanged($(event.target));
        // });

        // 更新bill显示
        $(".totalnumber").text(function() {
            return totalNumber;
        });
        $(".bill").text(function() {
            return bill;
        });
    }

    function animateCart(needForToggle) {
        var orderList = $(".shopping-cart .order-list");
        var orderListUl = $(".shopping-cart .order-list ul");

        // 根据reloadCart之后，html ul下面是否有子元素，来判断一下购物车是不是空的
        // 如果是空的，则改变右下角按钮，并且，关闭列表（且return），当用户在购物车减少商品时，如果没有商品了，便自动关闭列表
        // 不是空的，则显示支付
        if(0 == orderListUl.children().size()) {
            $(".go-pay").css({"display" : "none"});
            $(".ready-pay").css({"display" : "inline-block"});
            $(".ready-pay").text("购物车是空的");
            closeCart(orderList);

            // 需要return，不然因为decrement传过来needForToggle是0，则又会执行openCart
            return;
        } else {
            $(".ready-pay").css({"display" : "none"});
            $(".go-pay").css({"display" : "inline-block"});
        }

        // 如果是添加到购物车之后更新，则不需要关闭列表，所以不需要检查，直接更新
        // 但是如果列表本身就关闭着，那就得展开
        if("0px" == orderList.css("top") || null == orderList.css("top")) { // 注意这里要加上px单位

            // 防止页面为空的时候仍然能展开，比如页面刚被加载完，但是购物车没有东西
            // 但是用户添加商品，尽管没有也是空购物车，但是页面已经添加信息了，所以能够展开
            if(0 != orderListUl.children().size()) {
                openCart(orderList, orderListUl);
            }
        } else {
            // 检测是否需要关闭或者打开
            if(0 == needForToggle) {
                openCart(orderList, orderListUl);
                return;
            }
            closeCart(orderList);
        }
    }

    function openCart(orderList, orderListUl) {
        // 隐藏简略购物车信息
        $(".brief-order").css({"display" : "none"});
        // 展开列表
        orderList.animate({top : -(77 + 50 * orderListUl.children().size())});
    }

    function closeCart(orderList) {
        // 关闭列表
        orderList.animate({top : 0});

        // 添加简略购物车信息
        $(".brief-order").css({"display" : "block"});
        $(".brief-order .count").text(function() {
            return $(".totalnumber").text() + "张票";
        });
        $(".brief-order .price").text(function() {
            return "￥" + $(".bill").text();
        });
    }

    function incrementCart(arrangementId, sender) {
        // 改变输入框
        $(sender).prev().val(function(i, oldval) {
            return ++oldval;
        });

        // 遍历cookie并进行修改
        var jsonData = getCartCookie();
        $.each(jsonData, function(index, item) {
            if(item.arrangementId == arrangementId) {
                ++item.quantity;
            }
        });
        $.cookie("cart", JSON.stringify(jsonData), { path: '/', expires: 30 });
        reloadCart(jsonData);
        animateCart(0);
    }

    function decrementCart(arrangementId, sender) {
        var isZero = 0;
        $(sender).next().val(function(i, oldval) {
            if(1 == oldval) {
                isZero = 1;
                return 0;
            }
            return --oldval;
        });

        // 如果值之前是1，减一后变成零，所以删除对应的cookie
        var jsonData = getCartCookie();
        var index = 0;
        $.each(jsonData, function(i, item) {
            if(item.arrangementId == arrangementId) {
                --item.quantity;
                index = i;
            }
        });
        if(1 == isZero) {
            jsonData.splice(index, 1);
        }
        $.cookie("cart", JSON.stringify(jsonData), { path: '/', expires: 30 });
        reloadCart(jsonData);
        animateCart(0);
    }

    function cartInputChanged(jsThis) {
        var sender = $(jsThis);
        var arrangementId = sender.attr("id");
        var count = sender.val();

        if(!(count > 0 && count < 1000)) {
            // 还原之前的值
            sender.val(jsThis.oldvalue);
            // 不在需要更新cookie
            return;
        }

        // 修改cookie
        var jsonData = getCartCookie();
        $.each(jsonData, function(index, item) {
            if(item.arrangementId == arrangementId) {
                item.quantity = count;
            }
        });
        $.cookie("cart", JSON.stringify(jsonData), { path: '/', expires: 30 });
        reloadCart(jsonData);
        animateCart(0);
    }

    function clearCart() {
        if(confirm("确定清空购物车？")) {
            $.cookie("cart", "[]", { path: '/', expires: 30 });
            reloadCart(getCartCookie());
            animateCart(0);
        }
    }
</script>
