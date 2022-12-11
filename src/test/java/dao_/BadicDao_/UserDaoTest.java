package dao_.BadicDao_;

import dao_.Domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    @Test
    void queryUserByUsername() {
        UserDao userDao = new UserDao();
        if (userDao.queryUserByUsername("admin") != null) {
            System.out.println("我特么的查到了");
        } else {
            System.out.println("那没事了");
        }
    }

    @Test
    void queryUsernameAndPassword() {
        UserDao userDao = new UserDao();
        if (userDao.queryUsernameAndPassword("admin", "admin") != null) {
            System.out.println("我特么也查到了");
        } else {
            System.out.println("你没事吧");
        }
    }

    @Test
    void saveUser() {
        UserDao userDao = new UserDao();
        if (userDao.saveUser(new User(2, "liudatou", "123456", "123@qq.com")) > 0 ) {
            System.out.println("加进去了，我叼你md");
        } else {
            System.out.println("没有加进去噢宝");
        }
    }
}