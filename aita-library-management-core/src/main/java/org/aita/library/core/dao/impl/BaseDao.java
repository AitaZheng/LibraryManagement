package org.aita.library.core.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author 万松(Aaron)
 * @since 5.7
 */
public class BaseDao {
    PreparedStatement getPreparedStatement(String sql){
        String url = "jdbc:mysql://localhost:3306/book_manager";
        String usr = "root";
        String password = "123456";

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            throw new RuntimeException("找不到指定的类");
        }

        try {
            Connection conn = DriverManager.getConnection(url, usr, password);
            return conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
