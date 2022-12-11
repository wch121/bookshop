package service;

import dao_.BadicDao_.UserDao;
import dao_.Domain.User;

public class UserService {
    private UserDao userDao = new UserDao();

    /**
     * 注册
     * @param user
     */
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    /**
     * 登录
     * @param user 用户名
     * @return密码
     */
    public User login(User user) {
        return userDao.queryUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    /**
     * 根据用户名查看该用户名是否可用
     * @param name 用户名
     * @return 是否存在
     */
    public boolean existUsername(String name) {
        if (userDao.queryUserByUsername(name) == null) {
            return true;

        } else {
            return false;
        }


    }
}
