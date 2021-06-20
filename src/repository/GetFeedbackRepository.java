package com.library.repository;

import com.library.entity.FeedbackEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetFeedbackRepository {
    public List<FeedbackEntity> getFeedback() {
        List<FeedbackEntity> list = new ArrayList<>();
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 获取链接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms?useUnicode=true&characterEncoding=UTF-8", "root", "mmj980910");
            Statement statement = connection.createStatement();
            String sql = "SELECT comments, comments_date from feedback";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                String comments = resultSet.getString(1);
                String date = resultSet.getString(2);
                FeedbackEntity feedbackEntity = new FeedbackEntity(comments,date);
                list.add(feedbackEntity);
            }
            // 释放资源
            connection.close();
            statement.close();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
