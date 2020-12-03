package servlet;

import entity.Msg;
import entity.User;
import service.Impl.MsgServiceImpl;
import service.Impl.UserServiceImpl;
import service.MsgService;
import service.UserService;
import utils.Const;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 14:56
 * 描述:
 */
@WebServlet("/msg.do")
public class MsgServlet extends BaseServlet {
    MsgService msgService = null;
    UserService userService = null;

    public MsgServlet() {
        msgService = new MsgServiceImpl();
        userService = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }

    //查询用户列表
    public void queryList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        List<Msg> msgList = msgService.queryMsgByToUid(user.getId());
        request.setAttribute("msg", msgList);
        System.out.println(msgList.toString());
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    //查看详细信息
    public void queryDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Integer id = Integer.valueOf(request.getParameter("id"));
        Msg msg = msgService.queryMsgById(id);
        request.setAttribute("msgDetails", msg);
        request.getRequestDispatcher("/details.jsp").forward(request, response);
    }

    //删除信息
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer msgId = Integer.valueOf(id);
        int result = msgService.delete(msgId);
        queryList(request, response);
    }

    //发送信息
    public void send(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        Msg msg = null;
        User toUser = null;
        User loginUser = (User) request.getSession().getAttribute("user");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Const.DATAFORMAT);
        String msgResult = "";
        //TODO:email唯一性
        String mtitle = request.getParameter("mTitle");
        String email = request.getParameter("email");
        String mcontent = request.getParameter("mContent");

        toUser = userService.queryUserByEmail(email);

        if (toUser == null) {
            msgResult = "email不存在";
            response.sendRedirect(getServletContext().getContextPath() + "/send.jsp");
        } else {
            msg = new Msg();
            msg.setMtitle(mtitle);
            msg.setmContent(mcontent);
            msg.setFromUId(loginUser.getId());
            msg.setToUId(toUser.getId());
            msg.setReadFlag(Const.MSG_ISREAD_UNREAD);
            msg.setCreateTime(simpleDateFormat.format(new Date()));
            int result = msgService.insert(msg);
            msgResult=(result > 0)?"发送成功":"发送失败";
        }
        response.getWriter().write(msgResult);
//        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }
}
