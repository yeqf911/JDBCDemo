package com.yeqf.jdbcdemo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by yeqf on 2015/9/20.
 */
public class JDBCTest {
    public static void main(String[] args) {
        Connection conn = JDBCUtil.connect();
        try {
            String sql = "select id ,name ,email from myTable";

            Statement statement = conn.createStatement();
            ResultSet rst = statement.executeQuery(sql);

            while (rst.next()) {
                int id = rst.getInt(1);
                String name = rst.getString(2);
                String email = rst.getString(3);

                System.out.println(id + "," + name + "," + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
    }
}
