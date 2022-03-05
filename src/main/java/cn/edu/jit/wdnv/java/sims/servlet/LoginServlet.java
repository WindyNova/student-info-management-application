package cn.edu.jit.wdnv.java.sims.servlet;

import cn.edu.jit.wdnv.java.sims.dao.UserDao;
import cn.edu.jit.wdnv.java.sims.model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new UserDao().login(username, password);         //实例化UserDao对象
        //判断是否登录成功
        if (user != null) {//成功
            String level = user.getLevel();
            if (level.equals("用户")) {
                request.getSession().setAttribute("user", user);//将用户对象放到session中
                //转发到user.jsp中
                response.sendRedirect(request.getContextPath()+"/user.jsp");

              //  request.getRequestDispatcher("user.jsp").forward(request, response);
            } else {
                request.getSession().setAttribute("admin", user);//将管理员对象放到session中
                //转发到admin.jsp中
              //  request.getRequestDispatcher("admin.jsp").forward(request, response);

                response.sendRedirect(request.getContextPath()+"/admin.jsp");
            }
        } else {//失败
            response.setCharacterEncoding("gb2312");
            PrintWriter out=response.getWriter();
            response.setContentType("text/html");
            out.println("<script charset=\"gb2312\" type=\"text/javascript\">");
            out.println("alert(' 错误:用户名或密码错误！');");
            out.println("window.location.href = \"index.html\";");
            out.println("</script>");

        }
    }

}
