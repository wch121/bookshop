package service;

import dao_.Domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private UserService userService = new UserService();
    @Test
    void registerUser() {
        userService.registerUser(new User(3, "wawng", "678", "890@mn.com"));
    }

    @Test
    void login() {
        User user = new User(9, "AAA", "BBB", "CCC@.COM");
        if (userService.login(user) == null) {
            System.out.println("登陆失败");
        } else {
            System.out.println("登陆成功");
        }
    }

    @Test
    void existUsername() {
        if (userService.existUsername("admin")) {
            System.out.println("用户名不可用");
        } else {
            System.out.println("用户名可用");
        }

    }
}