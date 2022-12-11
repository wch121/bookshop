package dao_.BadicDao_;

import dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDao<T> {

    private QueryRunner qr = new QueryRunner();

    public List<T> queryMulti(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            return qr.query(connection, sql, new BeanListHandler<>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    public <T>T querySingle(String sql, Class<T> clazz, Object... parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            return qr.query(connection, sql, new BeanHandler<>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    public Object queryScalar(String sql, Object... parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            return qr.query(connection, sql, new ScalarHandler(), parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    public int update(String sql, Object... parameters) {
        Connection connection = JDBCUtilsByDruid.getConnection();
        try {
            return qr.update(connection, sql, parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }



}
