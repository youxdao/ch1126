package servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 作者：youjiahao
 * 日期: 2020/12/1 10:58
 * 描述:
 */

public abstract class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action =null;
        if(ServletFileUpload.isMultipartContent(request)){
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
            List<FileItem> list=null;

            try {
                list=servletFileUpload.parseRequest(request);
                for (FileItem fileItem:list) {
                    String filename = fileItem.getFieldName();
                    if(filename.equals("action")){
                        action=fileItem.getString();
                    }
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            }

            try {
                Method method=this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class,List.class);
                method.invoke(this,request,response,list);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }else{
            action=request.getParameter("action");
            Method method= null;
            try {
                method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
                method.invoke(this,request,response);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }
    }
}
