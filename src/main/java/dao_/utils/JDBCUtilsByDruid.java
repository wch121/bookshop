package dao_.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtilsByDruid {

    private static DruidDataSource druidDataSource = null;

    static {
        //用 DruidDataSourceFactory的化这里就是初始化properties，且记得try里面不要定义变量
        druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/book?rewriteBatchedStatement");
        druidDataSource.setUsername("root");
//        druidDataSource.setPassword("WL001214");
        druidDataSource.setPassword("123456");
        druidDataSource.setInitialSize(10);
        druidDataSource.setMaxActive(50);
        druidDataSource.setMinIdle(5);
        druidDataSource.setMaxWait(5000);

    }

    public static Connection getConnection() {
        try {
            return druidDataSource.getConnection();
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
