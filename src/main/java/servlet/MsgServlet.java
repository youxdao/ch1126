package servlet;

import entity.Msg;
import entity.User;
import service.Impl.MsgServiceImpl;
import service.MsgService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 14:56
 * 描述:
 */
@WebServlet("/msg.do")
public class MsgServlet extends BaseServlet {
    MsgService msgService = null;

    public MsgServlet() {
        msgService = new MsgServiceImpl();
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
        request.setAttribute("msg",msgList);
        System.out.println(msgList.toString());
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    //查看详细信息
    public void queryForOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Integer id= Integer.valueOf(request.getParameter("id"));
        Msg msg=msgService.queryMsgById(id);
        request.setAttribute("msgDetails",msg);
        request.getRequestDispatcher("/details.jsp").forward(request,response);
    }
}
