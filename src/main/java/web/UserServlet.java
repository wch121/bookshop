package web;

import com.google.gson.Gson;
import dao_.Domain.User;
import dao_.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BasicServlet {
    private UserService userService = new UserService();


    protected void ajaxChechUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        boolean b = userService.existUsername(username);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("username", b);
        Gson gson = new Gson();
        String s = gson.toJson(stringObjectHashMap);
        resp.getWriter().write(s);

    }
    /**
     * 注销
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }

    /**
     * 登录
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        User login = userService.login(user);

        String attribute = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");

        if (login == null) {
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", user.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            if (attribute != null && code.equalsIgnoreCase(attribute)) {
                req.getSession().setAttribute("user", login);
                req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
            } else {
                System.out.println(req.getAttribute("code_msg"));
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            }

        }

    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code = req.getParameter("code");
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        String str = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);

        if (str != null && code.equalsIgnoreCase(str)) {
            if (userService.existUsername(user.getUsername())) {

                userService.registerUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            } else {
                req.setAttribute("msg", "用户名错误，请重新输入");
                req.setAttribute("username", user.getUsername());
                req.setAttribute("email", user.getEmail());
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);

            }
        } else {
            req.setAttribute("msg", "验证码错误,请重新输入");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }


}
