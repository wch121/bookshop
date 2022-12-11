package utils;

import java.sql.*;
import java.util.ArrayList;

public class DruidTest02 {
    public static void main(String[] args) throws SQLException {
        String sql = "select * from actor where id >= ?";
        ArrayList<Actor> actors1 = new ArrayList<>();


        Connection connection = JDBCUtilsByDruid.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 1);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            Date borndate = resultSet.getDate("borndate");
            String phone = resultSet.getString("phone");
            System.out.println(id + '\t'+ name + '\t' + sex + '\t' + borndate + '\t' + phone);
            actors1.add(new Actor(id, name, sex, borndate, phone));
        }
        JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        for (Actor ac : actors1) {
            System.out.println(ac);
        }


    }
    public void a_test03() throws SQLException {
//        Connection connection = DriverManager.getConnection("jdbc:mysql:///db03", "root", "WL001214");
//        String sql = "insert into ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt();
    }
}
