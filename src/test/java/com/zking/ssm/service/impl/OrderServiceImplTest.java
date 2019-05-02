package com.zking.ssm.service.impl;

import com.zking.ssm.model.Order;
import com.zking.ssm.service.IOrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class OrderServiceImplTest extends BaseTestCase {
    @Autowired
    private IOrderService orderService;
    private Order order;

    @Override
    public void before() {
        super.before();
        order = new Order();
    }

    @Test
    public void load() {
        order.setOrderId(5);
        Order o = orderService.load(order);
        System.out.println(o);
    }
}