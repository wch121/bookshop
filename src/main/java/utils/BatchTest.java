package utils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchTest {
    public static void main(String[] args) throws Exception {
        Connection connection = JDBCUtils.getConnection("jdbc:mysql:///db03", "root", "WL001214");
        String sql = "insert into t1 values(?, ?)";
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "我宝");
            preparedStatement.setInt(2, 1000);
            int i1 = preparedStatement.executeUpdate();
        }

        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
        JDBCUtils.close(null, null, connection);
    }

    @Test
    public void a() throws Exception {
        Connection connection = JDBCUtils.getConnection("jdbc:mysql:///db03?rewriteBatchedStatement", "root", "WL001214");
        String sql = "insert into t1 values(?, ?)";
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "我宝");
            preparedStatement.setInt(2, 1000);
            preparedStatement.addBatch();
//            int i1 = preparedStatement.executeUpdate();
            if (i % 9 == 0) {
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }

        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
        JDBCUtils.close(null, null, connection);

    }

}
