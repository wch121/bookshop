package utils;

import java.sql.*;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String user;
    private static String passward;



    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            //这里我们说我们会把编译异常转化为运行异常，好让调用者可以任意处理

            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(String url, String user, String passward) {
        try {
            return DriverManager.getConnection(url, user, passward);
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public static void close(ResultSet set, PreparedStatement preparedStatement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
