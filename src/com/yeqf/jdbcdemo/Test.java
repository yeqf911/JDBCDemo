package com.yeqf.jdbcdemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeqf on 2015/9/20.
 */
public class Test {

    public static void main(String[] args) {
        //createtable();
        //insert();
        //delete();
        //update();
        List<User> list = query();
        System.out.println(list);
    }

    public static List<User> query() {
        Connection conn = JDBCUtil.connect();
        try {
            Statement statement = conn.createStatement();
            String sql = "SELECT  id,name,email FROM newtable";
            ResultSet rs = statement.executeQuery(sql);
            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                System.out.println(user);
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
        return null;
    }


    public static void update() {
        Connection conn = JDBCUtil.connect();
        try {
            Statement statement = conn.createStatement();
            String sql = "UPDATE newtable set email='ppppp@qq.com' WHERE id = 3";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("dsda");
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
    }

    public static void delete() {
        Connection conn = JDBCUtil.connect();
        try {
            Statement statement = conn.createStatement();
            String sql = "DELETE FROM newtable where id = 1 ";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
    }

    public static void insert() {
        Connection conn = JDBCUtil.connect();
        try {
            Statement statement = conn.createStatement();
            String sql = "INSERT INTO newtable (name,email) VALUE ('sdaasfa','bgjsdaf@163.com')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
    }

    public static void createtable() {
        Connection conn = JDBCUtil.connect();
        try {
            Statement statement = conn.createStatement();
            String sql = "create table newtable (id int primary key auto_increment,name varchar(20),email varchar(20))";
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
    }
}
