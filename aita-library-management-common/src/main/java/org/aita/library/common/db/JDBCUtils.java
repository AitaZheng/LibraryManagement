package org.aita.library.common.db;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.aita.library.exception.LibraryManagementSqlException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 万松(Aaron)
 * @since 5.7
 */
@Slf4j
@UtilityClass
public class JDBCUtils {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            log.error("register db driver", e);
        }
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/book_manager";
        String usr = "root";
        String password = "123456";
        try {
            return DriverManager.getConnection(url, usr, password);
        } catch (SQLException e) {
            throw new LibraryManagementSqlException(e);
        }
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            return getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            throw new LibraryManagementSqlException(e);
        }
    }


    public Statement getStatement() {
        try {
            return getConnection().createStatement();
        } catch (SQLException e) {
            throw new LibraryManagementSqlException(e);
        }
    }

    public <E> List<E> getDatas(String sql, ResultSetConvert<E> convert) {
        Statement statement = getStatement();
        try {
            ResultSet result = statement.executeQuery(sql);
            List<E> datas = new ArrayList<E>();

            while (result.next()) {
                E data=toEntity(result,convert);
                datas.add(data);
            }
            return datas;
        } catch (SQLException e) {
            throw new LibraryManagementSqlException(e);
        }finally {
            close(statement);
        }
    }

    public <E> E getData(String sql, ResultSetConvert<E> convert) {
        Statement statement = getStatement();
        try {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                return toEntity(result,convert);
            }
            return null;
        } catch (SQLException e) {
            throw new LibraryManagementSqlException(e);
        }
    }

    public <E> E toEntity(ResultSet resultSet, ResultSetConvert<E> convert) {
        E data = convert.transfer(resultSet);
        return data;
    }

    public void close(Connection connection){
        try {
            if(!connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            throw new LibraryManagementSqlException(e);
        }
    }

    public void close(Statement statement){
        try {
            Connection connection=statement.getConnection();
            if(!connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            throw new LibraryManagementSqlException(e);
        }
    }

}
