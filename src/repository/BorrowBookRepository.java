package com.library.repository;

import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BorrowBookRepository {

    public boolean addBorrow(String StuID, String BookID, String flag){
        // 判断是否存在要借阅的图书
        boolean check = false;

        // 获得当前系统时间
        java.util.Date borrowDate = new java.util.Date();
        // 定义calendar对象
        Calendar calendar = new GregorianCalendar();
        // 把当前系统时间赋值给calendar
        calendar.setTime(borrowDate);
        // 在日期中增加30天作为书到期日期
        calendar.add(calendar.DATE, 30);
        // 把calendar转换回日期格式
        java.util.Date dueDate = calendar.getTime();

        //将java.util.Date类型转换成java.sql.Date类型
        java.sql.Date BorrowDate = new java.sql.Date(borrowDate.getTime());
        java.sql.Date DueDate = new java.sql.Date(dueDate.getTime());

        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");

            // 判断图书馆是否存在此书
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM book WHERE book_id = '" + BookID + "';" ;
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                // SQL构建添加借书记录
                String sql1 = "INSERT INTO borrow_book (stu_id, book_id, borrow_date, due_date) VALUES ('" + StuID + "','" + BookID + "','" + BorrowDate + "','" + DueDate + "');";
                Statement statement1 = connection.createStatement();

                // SQL构建将book表中的数量减1
                String sql2 = "UPDATE book SET quantity = quantity - 1 WHERE book_id = '" + BookID + "';";
                Statement statement2 = connection.createStatement();

                // Update执行
                statement1.executeUpdate(sql1);
                statement2.executeUpdate(sql2);

                // 预约图书后借书
                if(flag.equals(1)){
                    String sql3 = "DELETE FROM book_reservation WHERE stu_id = '" + StuID + "'and book_id = '" + BookID + "';";
                    Statement statement3 = connection.createStatement();
                    statement3.executeUpdate(sql3);
                    statement3.close();
                }

                connection.close();
                statement1.close();
                statement2.close();
                statement.close();

                check = true;
            }
            else {
                statement.close();
                check = false;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
