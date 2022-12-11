package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Properties;

public class druidTest {
    public static void main(String[] args) throws Exception {
//        Properties properties = new Properties();
//        properties.load(new FileInputStream("D:\\java_code\\demo02\\src\\druid.properties"));
//        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection);
//        System.out.println("成功");
//        connection.close();
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/db01?serverTimezone=UTC");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("WL001214");
        druidDataSource.setInitialSize(10);
        druidDataSource.setMaxActive(50);
        druidDataSource.setMinIdle(5);
        druidDataSource.setMaxWait(5000);
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
        System.out.println("caonimb");
        connection.close();


    }

    @Test
    public void B_Test() throws Exception {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/db01");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("WL001214");
        druidDataSource.setInitialSize(10);
        druidDataSource.setMaxActive(50);
        druidDataSource.setMinIdle(5);
        druidDataSource.setMaxWait(5000);
        druidDataSource.setTestWhileIdle(false);
        druidDataSource.setValidationQuery("1");
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
        System.out.println("caonimb");
        connection.close();

    }
}
