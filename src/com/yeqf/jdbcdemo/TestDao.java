package com.yeqf.jdbcdemo;

import java.util.List;

/**
 * Created by yeqf on 2015/9/21.
 */
public class TestDao {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("wangsiwei");
        customer.setEmail("wsw@qq.com");
        CustomerDao dao = new CustometDaoImpl();
        dao.add(customer);
        customer =  dao.query(7);
        System.out.println(customer.getName());
        List<Customer> list = dao.query();
        System.out.println(list);
    }
}
