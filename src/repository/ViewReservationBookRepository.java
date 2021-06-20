package com.library.repository;

import com.library.entity.NowBookEntity;
import com.library.entity.ViewReservationEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewReservationBookRepository {

    /*
     * 方法：返回当前预约
     * 返回类型：List<ViewReservationEntity>
     * */
    public List<ViewReservationEntity> returnReservationBook(String StuID){
        List<ViewReservationEntity> list = new ArrayList<>();
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");

            // SQL构建
            String sql = "select book_id from book_reservation where stu_id =  '" + StuID + "';" ;
            Statement statement = connection.createStatement();

            // Query结果用ResultSet来接收
            ResultSet resultSet = statement.executeQuery(sql);

            // 对ResultSet解析
            while (resultSet.next()) {
                String BookID = resultSet.getString(1);
                // 根据图书号查询对应的书名和出版社
                String sql1 = "select book_name, publisher from book where book_id = '" + BookID + "';";
                Statement statement1 = connection.createStatement();
                ResultSet resultSet1 = statement.executeQuery(sql1);
                // 先调出指针指向第一行
                resultSet1.next();
                String BookName = resultSet1.getString(1);
                String Publisher = resultSet1.getString(2);
                // 将当前借阅图书的一条记录添加到list
                ViewReservationEntity viewReservationEntity =new ViewReservationEntity(BookID,BookName,Publisher);
                list.add(viewReservationEntity);
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
