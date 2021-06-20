package com.library.repository;

import java.sql.*;
import java.text.SimpleDateFormat;

public class BookReservationRepository {

    public void bookReservation(String StuID,String BookId){

        java.util.Date utilDate = new java.util.Date();

        //将java.util.Date类型转换成java.sql.Date类型
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");

            // 制作sql
            String sql = "INSERT INTO book_reservation (stu_id, book_id, reservation_date) VALUES ('" + StuID + "','" + BookId + "','" + sqlDate + "');";
            Statement statement = connection.createStatement();

            // SQL执行
            statement.executeUpdate(sql);

            connection.close();
            statement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
