package servlet;

import dao.Impl.UserDaoImpl;
import dao.UserDao;
import entity.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.Impl.UserServiceImpl;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 11:02
 * 描述:
 */
@WebServlet("/user.do")
public class UserServlet extends BaseServlet {
    UserDao userDao = new UserDaoImpl();
    UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    //注册
    public void register(HttpServletRequest request, HttpServletResponse response,List<FileItem> list) throws Exception {
        User user=new User();

        for (FileItem fileItem:list) {
            if(fileItem.isFormField()){//普通表单数据
                String filename=fileItem.getFieldName();
                String value=fileItem.getString("UTF-8");
                switch(filename){
                    case "username":
                        user.setUsername(value);
                        break;
                    case "password":
                        user.setPassword(value);
                        break;
                    case "email":
                        user.setEmail(value);
                        break;
                }
            }else{//上传的文件
                StringBuffer sb=new StringBuffer("C:\\programming\\WorkSpace\\dfrz02\\ch1126_Msg\\web\\images\\");
                sb.append(new Date().getTime());
                sb.append(fileItem.getName());
                String imgPath=sb.toString();
                fileItem.write(new File(imgPath));
                user.setImgPath(imgPath);
            }
        }

        int result=userService.register(user);
        response.sendRedirect(request.getContextPath() +"/login.jsp");
    }

    //登录
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rightToken = (String) request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        request.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        String token = request.getParameter("token");
        User user = userService.login(new User(username, password, null));

        if (user != null && rightToken.equals(token)) {//登录成功
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("/msg.do?action=queryList").forward(request, response);
        } else {//登录失败
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }

    }

    //修改用户信息
    public void update(HttpServletRequest request, HttpServletResponse response,List<FileItem> list) throws Exception {
        User user=new User();
        User loginUser= (User) request.getSession().getAttribute("user");
        for (FileItem fileItem:list) {
            if(fileItem.isFormField()){//普通表单数据
                String filename=fileItem.getFieldName();
                String value=fileItem.getString("UTF-8");
                switch(filename){
                    case "username":
                        user.setUsername(value);
                        break;
                    case "password":
                        user.setPassword(value);
                        break;
                    case "email":
                        user.setEmail(value);
                        break;
                }
            }else{//上传的文件
                String imgpath = loginUser.getImgPath();
                user.setImgPath(imgpath);
                if(!fileItem.getName().equals("")){
                    StringBuffer sb=new StringBuffer("C:\\programming\\WorkSpace\\dfrz02\\ch1126_Msg\\web\\images\\");
                    sb.append(new Date().getTime());
                    sb.append(fileItem.getName());
                    String imgPath=sb.toString();
                    fileItem.write(new File(imgPath));
                    user.setImgPath(imgPath);
                }

            }
        }
        user.setId(loginUser.getId());
        int result=userService.update(user);
        response.sendRedirect(request.getContextPath() +"/login.jsp");
    }


}
