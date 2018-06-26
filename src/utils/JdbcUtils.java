package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

	/**
     * 驱动
     */
    private final String DRIVER = "com.mysql.jdbc.Driver";

    /**
     * 数据库连接URL
     */
    private final String URL = "jdbc:mysql://localhost:3306/restaurant?characterEncoding=utf-8";

    /**
     * 数据库用户名
     */
    private final String USERNAME = "root";

    /**
     * 数据库密码
     */
    private final String USERPASSWORD= "1234";
    

    private static JdbcUtils utils = null;

    private JdbcUtils() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败。");
        }
    }

    public static JdbcUtils getInstance() {
        if (utils == null) {
            utils = new JdbcUtils();
        }
        return utils;
    }

    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL,USERNAME, USERPASSWORD);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("建立数据库连接失败。");
        }
        return null;
    }

    public void closeResult(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e){
                e.printStackTrace();
                System.out.println("ResultSet关闭异常。");
            }
        }
    }

    public void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e){
                e.printStackTrace();
                System.out.println("Statement关闭异常。");
            }
        }
    }

    public void closeConnection(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e){
                e.printStackTrace();
                System.out.println("Connection关闭异常。");
            }
        }
    }

    public void closeAll(ResultSet resultSet, Statement statement, Connection connection){
        closeResult(resultSet);
        closeStatement(statement);
        closeConnection(connection);
    }
}

