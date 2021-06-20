package com.library.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CancelReservationRepository {
    public void cancelReservation(String BookID, String StuID){
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");

            // SQL更新
            String sql = "DELETE FROM book_reservation where stu_id = '" + StuID + "' and book_id = '" + BookID +"';";
            Statement statement = connection.createStatement();

            // Update执行
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
