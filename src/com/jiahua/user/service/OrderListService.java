package com.jiahua.user.service;

import com.jiahua.model.OrderList;
import com.jiahua.model.OrderListDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yu on 9/23/14.
 */

@Service
public class OrderListService {

    @Autowired
    private OrderListDAO orderListDAO;

    public OrderListService() {}

    public List<OrderList> getAllOrderList() throws Exception  {
        List<OrderList> list = null;
        list = (List<OrderList>)orderListDAO.findAll();
        return list;
    }
}
