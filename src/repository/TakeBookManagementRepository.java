package com.library.repository;

import com.library.entity.BookEntity;
import com.library.entity.TakeBookEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TakeBookManagementRepository {

    public List<TakeBookEntity> returnTakeBook(String StuID){
        // 定义承接符合条件所有书的集合
        List<TakeBookEntity> list = new ArrayList<>();
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");

            // SQL构建
            String sql = "select book_id, stu_id, reservation_date from book_reservation where stu_id =  '" + StuID + "';" ;
            Statement statement = connection.createStatement();

            // Query结果用ResultSet来接收
            ResultSet resultSet = statement.executeQuery(sql);

            // 对ResultSet解析
            while (resultSet.next()) {
                // 给BookEntity的实体传值
                TakeBookEntity takeBookEntity = new TakeBookEntity(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
                // 把单本书传递给list
                list.add(takeBookEntity);
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
