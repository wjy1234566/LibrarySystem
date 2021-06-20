package com.library.repository;

import com.library.entity.BookEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchBookRepository {

    public List<BookEntity> searchBook(String search, String searchType){
        // 定义承接符合条件所有书的集合
        List<BookEntity> list = new ArrayList<>();
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");

            // SQL根据用户的查询方式来查询
            String sql = "select * from book where  " + searchType + " LIKE '%" + search + "%'";
            Statement statement = connection.createStatement();

            // Query结果用ResultSet来接收
            ResultSet resultSet = statement.executeQuery(sql);

            // 对ResultSet解析
            while (resultSet.next()) {
                // 给BookEntity的实体传值
                BookEntity bookEntity = new BookEntity(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7),resultSet.getString(8));
                // 把单本书传递给list
                list.add(bookEntity);
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
        return list;
    }
}
