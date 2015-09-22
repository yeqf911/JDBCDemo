package com.yeqf.jdbcdemo;

import java.util.List;

/**
 * Created by yeqf on 2015/9/21.
 */
public interface CustomerDao {
    void add(Customer customer);

    void update(Customer customer);

    void delete(int id);

    Customer query(int id);

    List<Customer> query();
}
