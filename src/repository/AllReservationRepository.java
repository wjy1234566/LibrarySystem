package com.library.repository;

import com.library.entity.BookEntity;
import com.library.entity.ReservationEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AllReservationRepository {

    public List<ReservationEntity> returnReservation() {
        List<ReservationEntity> list = new ArrayList<>();
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");

            // SQL语句
            String sql = "select * from book_reservation";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // 对resultSet解析
            // 对ResultSet解析
            while (resultSet.next()) {
                // 给BookEntity的实体传值
                ReservationEntity reservationEntity = new ReservationEntity(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));
                // 把单本书传递给list
                list.add(reservationEntity);
            }

            // 释放资源
            connection.close();
            statement.close();
            resultSet.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
