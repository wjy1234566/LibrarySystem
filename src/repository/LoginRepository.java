package com.library.repository;

import java.sql.*;


public class LoginRepository {

    public boolean checkLogin(String ID, String password) {
        boolean check = false;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");

            // SQL查询为executeQuery
            String StuID = ID;
            String Password = password;
            String sql_query = "select * from reader where stu_id = '" + StuID + "' and stu_password ='" + Password + "'";
            Statement statement = connection.createStatement();

            // Query结果用ResultSet来接收
            ResultSet resultSet = statement.executeQuery(sql_query);

            // 对ResultSet解析
            if (resultSet.next()) {
                check =  true;
            } else {
                check = false;
            }

            // 释放资源
            connection.close();
            statement.close();
            resultSet.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}