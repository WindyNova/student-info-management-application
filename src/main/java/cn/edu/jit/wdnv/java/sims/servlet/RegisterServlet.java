package cn.edu.jit.wdnv.java.sims.servlet;

import cn.edu.jit.wdnv.java.sims.dao.UserDao;
import cn.edu.jit.wdnv.java.sims.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //实例化UserDao对象
        User user = new UserDao().register(username, password, "用户");
        //判断是否注册成功
        if (user != null) {//成功
                request.getSession().setAttribute("user", user);//将用户对象放到session中
                //转发到user.jsp中
                request.getRequestDispatcher("user.jsp").forward(request, response);

        } else {//失败
            PrintWriter out=response.getWriter();
            response.setContentType("text/html");
            response.setCharacterEncoding("gb2312");
            out.println("<script charset=\"gb2312\" type=\"text/javascript\">");
            out.println("alert('错误:用户已经存在，不能重复注册！');");
            out.println("window.location.href = \"register.html\";");
            out.println("</script>");
        }
    }

}
