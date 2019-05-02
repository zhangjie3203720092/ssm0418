package com.zking.ssm.service.impl;

import com.zking.ssm.model.Customer;
import com.zking.ssm.service.ICustomerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CustomerServiceImplTest extends BaseTestCase {
    @Autowired
    private ICustomerService customerService;

    private Customer customer;

    @Override
    public void before() {
        super.before();
        customer = new Customer();
    }

    @Test
    public void list() {
        List<Customer> customerList = customerService.list(customer, pageBean);
        for (Customer c : customerList) {
            System.out.println(c);
        }
    }
}