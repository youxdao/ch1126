package servlet;

import dao.Impl.UserDaoImpl;
import dao.UserDao;
import entity.User;
import service.Impl.UserServiceImpl;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 11:02
 * 描述:
 */
@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    UserDao userDao = new UserDaoImpl();
    UserService userService=new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    //注册
    public void register(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User(username, password, email);
        int result = userService.register(user);
        System.out.println(result);

    }

    //登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rightToken= (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String token=request.getParameter("token");
        User user=userService.login(new User(username,password,null));

        if(user!=null&&rightToken.equals(token)){//登录成功
            HttpSession session=request.getSession();
            session.setAttribute("user",user);
            request.getRequestDispatcher("/msg.do?action=queryList").forward(request,response);
        }else{//登录失败
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }

    }
}
