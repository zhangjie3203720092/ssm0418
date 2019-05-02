package com.zking.ssm.service;

import com.zking.ssm.model.Customer;
import com.zking.ssm.utils.PageBean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICustomerService {
    int deleteByPrimaryKey(Customer customer);

    int insert(Customer customer);

    int insertSelective(Customer customer);

    Customer selectByPrimaryKey(Customer customer);

    int updateByPrimaryKeySelective(Customer customer);

    int updateByPrimaryKey(Customer customer);
    List<Customer> list(Customer customer, PageBean pageBean);


}