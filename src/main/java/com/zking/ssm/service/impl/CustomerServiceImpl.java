package com.zking.ssm.service.impl;

import com.zking.ssm.mapper.CustomerMapper;
import com.zking.ssm.model.Customer;
import com.zking.ssm.service.IBookService;
import com.zking.ssm.service.ICustomerService;
import com.zking.ssm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerMapper customerMapper;



    @Override
    public int deleteByPrimaryKey(Customer customer) {
        return customerMapper.deleteByPrimaryKey(customer.getCustomerId());
    }

    @Override
    public int insert(Customer record) {

        return customerMapper.insert(record);
    }

    @Override
    public int insertSelective(Customer record) {
        return 0;
    }

    @Override
    @Transactional(readOnly = true)
    public Customer selectByPrimaryKey(Customer customer) {

        return customerMapper.selectByPrimaryKey(customer.getCustomerId());
    }

    @Override
    public int updateByPrimaryKeySelective(Customer record) {
        return 0;
    }

    @Override
    public List<Customer> list(Customer customer, PageBean pageBean) {
        return customerMapper.list(customer);
    }

    @Override
    public int updateByPrimaryKey(Customer record) {

        return customerMapper.updateByPrimaryKey(record);
    }
}
