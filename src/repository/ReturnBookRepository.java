package com.library.repository;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ReturnBookRepository {

    public boolean addBorrow(String StuID, String BookID){
        boolean check = false;

        // 获得当前系统时间
        java.util.Date returnDate = new java.util.Date();

        //将java.util.Date类型转换成java.sql.Date类型
        java.sql.Date ReturnDate = new java.sql.Date(returnDate.getTime());

        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");

            // SQL构建
            String sql = "UPDATE borrow_book  set return_date ='" + ReturnDate + "' WHERE stu_id = '" + StuID + "' and book_id = '" + BookID + "';" ;
            Statement statement = connection.createStatement();

            // Update执行
            int resultSet = statement.executeUpdate(sql);

            if (resultSet == 0){
                check = false;
            }
            else {
                // 还书成功后，在book表中的相关书籍的数量 + 1
                String sql2 = "UPDATE book SET quantity = quantity + 1 WHERE book_id = '" + BookID + "';";
                Statement statement2 = connection.createStatement();
                statement2.executeUpdate(sql2);
                check = true;
            }

            connection.close();
            statement.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
