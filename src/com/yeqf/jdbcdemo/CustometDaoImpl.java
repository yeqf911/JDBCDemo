package com.yeqf.jdbcdemo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by yeqf on 2015/9/21.
 */
public class CustometDaoImpl implements CustomerDao {


    @Override
    public void add(Customer customer) {
        Connection connection = JDBCUtil.connect();
        String sql = "INSERT INTO newtable (name,email) VALUES(?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(connection);
        }
    }

    @Override
    public void update(Customer customer) {
        Connection connection = JDBCUtil.connect();
        String sql = "UPDATE newtable SET  name=?,email=? WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getEmail());
            pstmt.setInt(3, customer.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = JDBCUtil.connect();
        String sql = "DELETE FROM newtable WHERE id=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
    }

    @Override
    public Customer query(int id) {
        Connection connection = JDBCUtil.connect();
        String sql = "select * from newtable WHERE id = ?;";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt(1));
                customer.setName(rs.getString(2));
                customer.setEmail(rs.getString(3));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
        return null;
    }

    @Override
    public List<Customer> query() {
        Connection connection = JDBCUtil.connect();
        String sql = "SELECT * FROM newtable;";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            List<Customer> list = new ArrayList<>();
            while (rs.next()) {
                Customer c = new Customer();
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                c.setId(id);
                c.setName(name);
                c.setEmail(email);
                list.add(c);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection);
        }
        return null;
    }
}
