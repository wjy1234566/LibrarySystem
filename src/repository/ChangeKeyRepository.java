package com.library.repository;

import java.sql.*;

public class ChangeKeyRepository {

    public void changeKey(String password, String StuID){
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");

            // SQL更新
            String newPassword = password;
            String sql = "update reader set stu_password ='" + password + "'where stu_id = '" + StuID + "'";
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
