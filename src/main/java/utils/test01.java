package utils;

import com.google.gson.Gson;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class test01 {
    public static void main(String[] args) {
//        Connection connection = null;
//        System.out.println(connection);
//        String sql = null;

//        String sql = "update t1 set money = ? where name = ?";
//        String sql1 = "update t1 set money = ? where name = ?";
//
//        PreparedStatement preparedStatement;
//        try {
//            connection = JDBCUtils.getConnection("jdbc:mysql:///db03", "root", "WL001214");
//            connection.setAutoCommit(false);
//            preparedStatement = connection.prepareStatement(sql);
//
//            preparedStatement.setInt(1, 800);
//            preparedStatement.setString(2, "大头");
//            int i = preparedStatement.executeUpdate();
//
////            int j = 1 / 0;
//
//            preparedStatement = connection.prepareStatement(sql1);
//
//            preparedStatement.setInt(1, 1100);
//            preparedStatement.setString(2, "小丽");
//            preparedStatement.executeUpdate();
//            connection.commit();
//
//        } catch (SQLException e) {
//            System.out.println("捕捉异常啦，完蛋");
//            try {
//                connection.rollback();
//            } catch (SQLException y) {
//
//                throw new RuntimeException(y);
//            }
//
//            throw new RuntimeException(e);
//        }
//
//        JDBCUtils.close(null, preparedStatement, connection);
//
//


    }
    List<Object> list = new ArrayList<>();

    @Test
    public void test() {
        list.add("datou1");

        Gson gson = new Gson();
        String s = gson.toJson(list);
        System.out.println(s);
    }
}
