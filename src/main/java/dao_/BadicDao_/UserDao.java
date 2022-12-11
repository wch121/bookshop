package dao_.BadicDao_;

import dao_.Domain.User;

import java.util.List;

public class UserDao extends BasicDao{

    /**
     *根据用户名查询用户信息
     * @param name 用户名
     * @return 如果返回null，则说明没有
     */
    public User queryUserByUsername(String name) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where username = ?";
//        System.out.println(querySingle(sql, User.class, name));
        return (User)querySingle(sql, User.class, name);
    }

    /**
     * 根据用户名和密码来查询用户信息
     * @param name
     * @param password
     * @return
     */
    public User queryUsernameAndPassword(String name, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user where `username` = ? and `password` = ? ";
        return (User) querySingle(sql, User.class, name, password);
    }

    public int saveUser(User user) {
        String sql = "insert into t_user(`username`, `password`, `email`) values(?, ?, ?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
