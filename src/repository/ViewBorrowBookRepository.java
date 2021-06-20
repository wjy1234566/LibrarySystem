package com.library.repository;

import com.library.entity.HistoryBookEntity;
import com.library.entity.NowBookEntity;
import com.library.entity.TakeBookEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewBorrowBookRepository {
    /*
    * 方法：返回当前借阅
    * 返回类型：List<NowBook>
    * */
    public List<NowBookEntity> returnNowBook(String StuID){
        List<NowBookEntity> list = new ArrayList<>();
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");

            // SQL构建
            String sql = "select book_id, due_date from borrow_book where stu_id =  '" + StuID + "' and return_date is null ;" ;
            Statement statement = connection.createStatement();

            // Query结果用ResultSet来接收
            ResultSet resultSet = statement.executeQuery(sql);

            // 对ResultSet解析
            while (resultSet.next()) {
                String BookID = resultSet.getString(1);
                String Due_date = resultSet.getString(2);
                // 根据图书号查询对应的书名和出版社
                String sql1 = "select book_name, publisher from book where book_id = '" + BookID + "';";
                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement1.executeQuery(sql1);
                // 先调出指针指向第一行
                resultSet1.next();
                String BookName = resultSet1.getString(1);
                String Publisher = resultSet1.getString(2);
                // 将当前借阅图书的一条记录添加到list
                NowBookEntity nowBookEntity = new NowBookEntity(BookID,BookName,Publisher,Due_date);
                list.add(nowBookEntity);
                statement1.close();
                resultSet1.close();
            }

            // 释放资源
            statement.close();
            resultSet.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
     * 方法：返回历史借阅
     * 返回类型：List<HistoryBook>
     * */
    public List<HistoryBookEntity> returnHistoryBook(String StuID){
        // 定义承接符合条件所有书的集合
        List<HistoryBookEntity> list = new ArrayList<>();
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");
            // SQL构建
            String sql = "select book_id, return_date from borrow_book where stu_id =  '" + StuID + "' and return_date is not null ;" ;
            Statement statement = connection.createStatement();

            // Query结果用ResultSet来接收
            ResultSet resultSet = statement.executeQuery(sql);

            // 对ResultSet解析
            while (resultSet.next()) {
                String BookID = resultSet.getString(1);
                String ReturnDate = resultSet.getString(2);
                // 根据图书号查询对应的书名和出版社
                String sql1 = "select book_name, publisher from book where book_id = '" + BookID + "';";
                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement1.executeQuery(sql1);
                resultSet1.next();
                String BookName = resultSet1.getString(1);
                String Publisher = resultSet1.getString(2);
                // 将当前借阅图书的一条记录添加到list
                HistoryBookEntity historyBookEntity = new HistoryBookEntity(BookID, BookName, Publisher, ReturnDate);
                list.add(historyBookEntity);
                statement1.close();
                resultSet1.close();
            }
            // 释放资源
            statement.close();
            resultSet.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

