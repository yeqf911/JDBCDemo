package com.yeqf.jdbcdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yeqf on 2015/9/20.
 */
public class Test2 {

    public static void main(String[] args) {
        //insert("huzi","huzi@qq.com");
        //update("lele", 4);
        //delete(4);
        query(3);

    }

    public static void query(int id) {
        String sql = "SELECT name,email FROM newtable WHERE id = ?";
        Connection connection = null;
        try {
            connection = JDBCUtil.connect();
            PreparedStatement pstam = connection.prepareStatement(sql);
            pstam.setInt(1, id);
            ResultSet rs = pstam.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString(2);
                System.out.println(name + " " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        String sql = "DELETE FROM newtable WHERE id = ?";
        Connection connection = null;
        try {
            connection = JDBCUtil.connect();
            PreparedStatement pstam = connection.prepareStatement(sql);
            pstam.setInt(1, id);
            pstam.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String name,int id) {
        String sql = "UPDATE newtable set name=? WHERE id = ?";
        Connection connection;
        try {
            connection = JDBCUtil.connect();
            PreparedStatement pstam = connection.prepareStatement(sql);
            pstam.setString(1,name);
            pstam.setInt(2, id);
            pstam.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insert(String name,String email) {
        String sql = "INSERT INTO newtable (name,email) VALUE(?,?)";
        Connection connection = null;
        try {
            connection = JDBCUtil.connect();
            PreparedStatement pstam = connection.prepareStatement(sql);
            pstam.setString(1,name);
            pstam.setString(2, email);
            pstam.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
