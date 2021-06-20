package com.library.repository;

import java.sql.*;

public class BookRemoveRepository {
    public boolean removeBook(String BookID){
        boolean check = false;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");

            // 查询是否存在已经注册过的读者
            String sql_query = "select * from book where book_id = '" + BookID + "';" ;
            Statement statement_query = connection.createStatement();
            ResultSet resultSet_query = statement_query.executeQuery(sql_query);

            if(resultSet_query.next()){
                // SQL拼接
                String sql = "DELETE from book where book_id = '" + BookID + "';";
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
