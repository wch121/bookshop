package sevlet;

import com.mysql.cj.jdbc.Driver;
import org.junit.Test;

import java.sql.*;
@SuppressWarnings({"all"})
public class test {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql:///db01";
        String user = "root";
        String passward = "WL001214";
        Connection connection = DriverManager.getConnection(url, user, passward);
        System.out.println(connection);
        String sql = "update t1 set name = ? where number = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setString(1, "wnngwang");
//        int i = preparedStatement.();
//        ResultSet resultSet = preparedStatement.executeQuery();
        preparedStatement.setString(1, "king");
        preparedStatement.setString(2, "wangwang");
        int i = preparedStatement.executeUpdate();
        System.out.println(i >= 0? "成功啦":"掉毛一个");
        preparedStatement.close();
//        statement.close();
        connection.close();

    }



}


