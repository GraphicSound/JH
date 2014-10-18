package com.jiahua.user.controller;

import com.google.gson.*;
import com.jiahua.model.OrderList;
import com.jiahua.model.Orders;
import com.jiahua.user.service.ArrangementService;
import com.jiahua.user.service.MovieService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Controller
public class ShoppingCartAction extends ActionSupport {
    private static final Logger log = LoggerFactory.getLogger(ShoppingCartAction.class);

    @Autowired
    private MovieService movieService;
    @Autowired
    private ArrangementService arrangementService;

    private List<OrderList> orderLists = new ArrayList<OrderList>();
    private Double totalPrice = 0.0;

    private Map session;
    private HttpServletRequest request;

    public ShoppingCartAction() {
    }

    @Override
    public void validate() {
        if (null == session) {
            session = ActionContext.getContext().getSession();
            request = (HttpServletRequest)ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        }
        if (null == session.get("orderLists")) {
            log.info("创建orderLists");
            session.put("orderLists", orderLists);
        }

        // 重置一下，不然重复提交会重复
        orderLists.clear();
        totalPrice = 0.0;
    }

    public String checkout() throws Exception {

        // 防止用户禁用cookies而出错，但是一般情况下不可能
        if (null == request.getCookies()) {
            return "cookies null";
        }

        // 遍历cookie里面购物车信息
        for (Cookie cookie : request.getCookies()) {
            if ("cart".equals(cookie.getName())) {
                String cartString = cookie.getValue();
                cartString = URLDecoder.decode(cartString, "utf-8"); // 不然全是百分号
                System.out.println(cartString);

                JsonParser jsonParser = new JsonParser();
                JsonElement jsonElement = jsonParser.parse(cartString);
                Iterator<JsonElement> iterator = jsonElement.getAsJsonArray().iterator();
                String title = null;
                String ArrangementIdString = null;
                String showTime = null;
                String theater = null;
                String priceString = null;
                String quantityString = null;
                while (iterator.hasNext()) {
                    JsonObject jsonObject = iterator.next().getAsJsonObject();
                    title = jsonObject.get("title").getAsString();
                    ArrangementIdString = jsonObject.get("arrangementId").getAsString();
                    showTime = jsonObject.get("showTime").getAsString();
                    theater = jsonObject.get("theater").getAsString();
                    priceString = jsonObject.get("price").getAsString();
                    quantityString = jsonObject.get("quantity").getAsString();

                    // 封装成orderList
                    OrderList orderList = new OrderList();
                    orderList.setPrice(Double.parseDouble(priceString));
                    orderList.setQuantity(Integer.parseInt(quantityString));
                    orderList.setAmount(orderList.getPrice() * orderList.getQuantity());
                    orderList.setArrangementId(Integer.parseInt(ArrangementIdString));
                    totalPrice += orderList.getAmount();

                    // 添加到orderLists
                    orderLists.add(orderList);
                }
            }
        }
        log.info("总票价 : " + totalPrice);
        session.put("totalPrice", totalPrice.toString());
        return SUCCESS;
    }

    public String checkoutAdmitted() throws Exception {

        // 先检测用户有无登陆
        if (null == session.get("user")) {
            return LOGIN;
        }

        Orders orders = new Orders();
        orders.setCommitTime(new Timestamp(System.currentTimeMillis()));
        orders.setAmount(totalPrice);

        return SUCCESS;
    }
}
