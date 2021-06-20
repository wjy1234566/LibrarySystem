package com.library.repository;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RenewBookRepository {
    public boolean renewBook(String StuID, String BookID){
        boolean check = false;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");

            // 查询是否可以续借
            String sql_query = "select renew , due_date from borrow_book where stu_id = '" + StuID + "' and book_id = '" + BookID + "' and return_date is null ;" ;
            Statement statement_query = connection.createStatement();
            ResultSet resultSet_query = statement_query.executeQuery(sql_query);
            resultSet_query.next();
            // 取出可以renew的次数
            int renew = resultSet_query.getInt(1);
            java.util.Date due_date = resultSet_query.getDate(2);

            if(renew > 0){
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(due_date);
                // 在日期中增加30天作为书续借后到期日期
                calendar.add(calendar.DATE, 30);
                // 把calendar转换回日期格式
                java.util.Date calendarTime = calendar.getTime();

                //将java.util.Date类型转换成java.sql.Date类型
                java.sql.Date DueDate = new java.sql.Date(calendarTime.getTime());

                // SQL拼接
                String sql = "UPDATE borrow_book SET due_date = '" + DueDate + "', renew = '" + 0 + "' where stu_id = '" + StuID + "' and book_id = '" + BookID + "' and return_date is null ;";
                Statement statement = connection.createStatement();
                statement.executeUpdate(sql);
                check = true;
                // 释放资源
                statement.close();
            }

            connection.close();
            statement_query.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
