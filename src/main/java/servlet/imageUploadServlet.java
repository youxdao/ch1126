package servlet;


import utils.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 作者：youjiahao
 * 日期: 2020/12/3 9:42
 * 描述:
 */
@WebServlet("/imageUpload")
public class imageUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //防止中文乱码
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        //设置json格式
        response.setContentType("application/json;charset=utf-8");
        String s = "{ \"errno\":0,\"data\":[ \"http://localhost:80/upload/" + FileUtils.singleUpload(request, response).get("fileName") + "\"] }";
        response.getWriter().write(s);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
