package com.library.repository;

import java.sql.*;


public class FeedbackRepository {
    public void newFeedback(String comment) {
        // 获得当前系统时间
        java.util.Date Date = new java.util.Date();

        //将java.util.Date类型转换成java.sql.Date类型
        java.sql.Date CommentDate = new java.sql.Date(Date.getTime());

        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO feedback (comments, comments_date) VALUES ('" + comment + "','" + CommentDate + "');";
            statement.executeUpdate(sql);

            // 释放资源
            connection.close();
            statement.close();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}


