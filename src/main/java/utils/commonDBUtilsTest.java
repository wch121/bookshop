package utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class commonDBUtilsTest {
    public static void main(String[] args) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        String sql = "select * from actor where id > ?";
        QueryRunner queryRunner = new QueryRunner();
        try {
            List<Actor> query = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);
            for (Actor ac : query) {
                System.out.println(query);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
