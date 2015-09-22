package com.yeqf.jdbcdemo;

import java.sql.*;

/**
 * Created by yeqf on 2015/9/21.
 * 创建过程，有函数可以用。可以先通过数据库命令行创建相应的函数，再在代码里面调用
 */
public class Test3 {

    public static void main(String[] args) {
        //
        //show();
        //insert();
        //delete();
        getNameById();
    }


    public static void getNameById() {
        Connection connection = JDBCUtil.connect();
        try {
            CallableStatement cstm = connection.prepareCall("{call getNAmeById(?,?)}");
            cstm.setInt(1, 6);
            //注册输出参数
            cstm.registerOutParameter(2, Types.CHAR);
            cstm.execute();
            String name = cstm.getString(2);
            //这一步是干嘛的？好像执不执行没关系啊
            cstm.executeUpdate();
            System.out.println(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        Connection connection = JDBCUtil.connect();
        try {
            CallableStatement cstm = connection.prepareCall("{call del(?)}");
            cstm.setInt(1, 5);
            cstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void insert() {
        Connection connection = JDBCUtil.connect();
        try {
            CallableStatement cstm = connection.prepareCall("{call insert_cus(?,?)}");
            cstm.setString(1, "xiaomifng");
            cstm.setString(2, "xiaoming@gamil.com");
            cstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void show() {
        Connection connection = JDBCUtil.connect();
        try {
            CallableStatement cstm = connection.prepareCall("{call call_yeqf()}");
            ResultSet rs = cstm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name") + " " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
