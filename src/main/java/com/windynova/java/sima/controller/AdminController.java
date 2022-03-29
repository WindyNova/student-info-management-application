package com.windynova.java.sima.controller;


import com.windynova.java.sima.entity.*;

import com.windynova.java.sima.entity.Class;
import com.windynova.java.sima.service.impl.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/admin")
public class AdminController{

    @Resource



    /*-------------------------------- 用户 -----------------------------------*/
    //查询所有用户
    @RequestMapping(value="addbook",method = RequestMethod.POST)
    protected void queryAllUser{
        response.setContentType("text/html;charset=utf-8");
        UserDao userDao = new UserDao();

        ArrayList<User> results = userDao.query_all_user();
        PrintWriter out = response.getWriter();
        //输出结果
        if (results != null) {
            out.write("<div class='all'>");
            out.write("<div><span>用户名</span><span>密码</span><span>权限级别</span></div>");
            for (User i : results) {
                out.write("<div>");
                out.write("<span>" + i.getUsername() + "</span>");
                out.write("<span>" + i.getPassword() + "</span>");
                out.write("<span>" + i.getLevel() + "</span>");
                out.write("</div>");
            }
            out.write("</div>");
        }

        out.flush();
        out.close();
    }

    //插入用户
    protected void insert_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String level = request.getParameter("level");

        int status = new UserDao().insert_user(username, Encryptor.MD5Encrypt(password), level);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "用户插入成功！";
        } else {
            info = "错误：用户插入失败！";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    //删除用户
    protected void delete_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");

        int status = new UserDao().delete_user(username);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "成功删除名为" + username + "用户！";
        } else {
            info = "错误：删除用户失败！";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    //修改用户
    protected void alter_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String after_username = request.getParameter("after_username");
        String after_password = request.getParameter("after_password");
        String after_level = request.getParameter("after_level");

        int status = new UserDao().alter_user(username, after_username, Encryptor.MD5Encrypt(after_password), after_level);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "名为" + username + "用户信息修改成功！";
        } else {
            info = "错误：修改用户失败!";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    /*-------------------------------- 院系-----------------------------------*/
    // 查询所有院系
    protected void query_all_department(HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");

        ArrayList<Department> results = new DepartmentDao().query_all_department();
        PrintWriter out = response.getWriter();
        // 输出结果
        if (results != null) {
            out.write("<div class='all'>");
            out.write("<div><span>系编号</span><span>系名</span></div>");
            for (Department i : results) {
                out.write("<div>");
                out.write("<span>" + i.getDno() + "</span>");
                out.write("<span>" + i.getDname() + "</span>");
                out.write("</div>");
            }
            out.write("</div>");
        }
        out.flush();
        out.close();
    }

    // 插入院系
    protected void insert_department(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer dno = Integer.valueOf(request.getParameter("dno"));
        String dname = request.getParameter("dname");
        int status = new DepartmentDao().insert_department(dno, dname);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "院系" + dname + "插入成功！";
        } else {
            info = "错误：院系插入失败！";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    // 删除院系
    protected void delete_department(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer dno = Integer.valueOf(request.getParameter("dno"));
        int status = new DepartmentDao().delete_department(dno);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "成功删除" + dno + "号院系！";
        } else {
            info = "错误：删除院系失败！";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    // 修改院系
    protected void alter_department(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer dno = Integer.valueOf(request.getParameter("dno"));
        Integer after_dno = Integer.valueOf(request.getParameter("after_dno"));
        String after_dname = request.getParameter("after_dname");
        int status = new DepartmentDao().alter_department(dno, after_dno, after_dname);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = dno + "号系修改成功！";
        } else {
            info = "错误：修改院系失败!";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    /*-------------------------------- 班级-----------------------------------*/
    // 查询所有班级
    protected void query_all_class(HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Class> results = new ClassServiceImpl().query_all_class();
        PrintWriter out = response.getWriter();
        // 输出结果
        if (results != null) {
            out.write("<div class='all'>");
            out.write("<div><span>班级编号</span><span>班级名</span><span>所属院系</span></div>");
            for (Class i : results) {
                out.write("<div>");
                out.write("<span>" + i.getClno() + "</span>");
                out.write("<span>" + i.getClname() + "</span>");
                out.write("<span>" + i.getDno() + "</span>");
                out.write("</div>");
            }
            out.write("</div>");
        }
        out.flush();
        out.close();
    }

    // 插入班级
    protected void insert_class(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer clno = Integer.valueOf(request.getParameter("clno"));
        String clname = request.getParameter("clname");
        Integer dno = Integer.valueOf(request.getParameter("dno"));
        int status = new ClassServiceImpl().insert_class(clno, clname, dno);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "班级" + clname + "插入成功！";
        } else {
            info = "错误：班级插入失败！";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    // 删除班级
    protected void delete_class(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer clno = Integer.valueOf(request.getParameter("clno"));
        int status = new ClassServiceImpl().delete_class(clno);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "成功删除" + clno + "班级！";
        } else {
            info = "错误：删除班级失败！";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    // 修改班级
    protected void alter_class(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer clno = Integer.valueOf(request.getParameter("clno"));
        Integer after_clno = Integer.valueOf(request.getParameter("after_clno"));
        String after_clname = request.getParameter("after_clname");
        Integer after_dno = Integer.valueOf(request.getParameter("after_dno"));
        int status = new ClassServiceImpl().alter_class(clno, after_clno, after_clname, after_dno);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "班级" + clno + "修改成功！";
        } else {
            info = "错误：修改班级失败!";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    /*-------------------------------- 学生-----------------------------------*/
    // 查询所有学生
    protected void query_all_student(HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        ArrayList<Student> results = new StudentDao().query_all_student();
        PrintWriter out = response.getWriter();
        // 输出结果
        if (results != null) {
            out.write("<div class='all'>");
            out.write("<div><span>学号</span><span>姓名</span><span>性别</span><span>年龄</span><span>所在班级编号</span></div>");
            for (Student i : results) {
                out.write("<div>");
                out.write("<span>" + i.getSno() + "</span>");
                out.write("<span>" + i.getSname() + "</span>");
                out.write("<span>" + i.getSsex() + "</span>");
                out.write("<span>" + i.getSage() + "</span>");
                out.write("<span>" + i.getClno() + "</span>");
                out.write("</div>");
            }
            out.write("</div>");
        }
        out.flush();
        out.close();
    }

    // 插入学生
    protected void insert_student(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer sno = Integer.valueOf(request.getParameter("sno"));
        String sname = request.getParameter("sname");
        String ssex = request.getParameter("ssex");
        byte sage = Byte.parseByte(request.getParameter("sage"));
        Integer clno = Integer.valueOf(request.getParameter("clno"));
        int status = new StudentDao().insert_student(sno, sname, ssex, sage, clno);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "学生" + sname + "插入成功！";
        } else {
            info = "错误：学生插入失败！";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    // 删除学生
    protected void delete_student(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer sno = Integer.valueOf(request.getParameter("sno"));
        int status = new StudentDao().delete_student(sno);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "成功删除" + sno + "号学生！";
        } else {
            info = "错误：删除学生失败！";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    // 修改学生信息
    protected void alter_student(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer sno = Integer.valueOf(request.getParameter("sno"));
        Integer after_sno = Integer.valueOf(request.getParameter("after_sno"));
        String after_sname = request.getParameter("after_sname");
        String after_ssex = request.getParameter("after_ssex");
        byte after_sage = Byte.parseByte(request.getParameter("after_sage"));
        Integer after_clno = Integer.valueOf(request.getParameter("after_clno"));
        int status = new StudentDao().alter_class(sno, after_sno, after_sname, after_ssex, after_sage, after_clno);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "学生" + sno + "信息修改成功！";
        } else {
            info = "错误：修改学生信息失败!";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    /*-------------------------------- 课程 -----------------------------------*/
    //查询课程平均分
    protected void course_avg(HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        ArrayList<CourseAvg> results = new CourseDao().course_avg();
        PrintWriter out = response.getWriter();
        if (results != null) {
            //输出结果
            out.write("<div class='all'>");
            out.write("<div><span>课程号</span><span>课程名称</span><span>执教老师</span><span>学分</span><span>平均分</span></div>");
            for (CourseAvg i : results) {
                out.write("<div>");
                out.write("<span>" + i.getCno() + "</span>");
                out.write("<span>" + i.getCname() + "</span>");
                out.write("<span>" + i.getCteacher() + "</span>");
                out.write("<span>" + i.getCcredit() + "</span>");
                out.write("<span>" + i.getAvg() + "</span>");
                out.write("</div>");
            }
            out.write("</div>");
        }
        out.flush();
        out.close();
    }

    //查询课程不及格率
    protected void fail_rate(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        ArrayList<CourseFailRate> results = new CourseDao().fail_rate();
        PrintWriter out = response.getWriter();
        // 输出结果
        if (results != null) {
            out.write("<div class='all'>");
            out.write("<div><span>课程号</span><span>课程名称</span><span>执教老师</span><span>学分</span><span>平均分</span></div>");
            for (CourseFailRate i : results) {
                out.write("<div>");
                out.write("<span>" + i.getCno() + "</span>");
                out.write("<span>" + i.getCname() + "</span>");
                out.write("<span>" + i.getCteacher() + "</span>");
                out.write("<span>" + i.getCcredit() + "</span>");
                out.write("<span>" + i.getFail_rate() + "%</span>");
                out.write("</div>");
            }
            out.write("</div>");
        }
        out.flush();
        out.close();
    }

    // 查询课程排名
    protected void course_ranking(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer Cno = Integer.valueOf(request.getParameter("cno"));
        ArrayList<CourseRanking> results = new CourseDao().course_ranking(Cno);
        PrintWriter out = response.getWriter();
        // 输出结果
        if (results != null) {
            out.write("<div class='all'>");
            out.write("<div><span>学号</span><span>所在系</span><span>班级名称</span><span>姓名</span><span>性别</span><span>年龄</span><span>成绩</span><span>排名</span></div>");
            int no = 1;
            for (CourseRanking i : results) {
                out.write("<div>");
                out.write("<span>" + i.getSno() + "</span>");
                out.write("<span>" + i.getDname() + "</span>");
                out.write("<span>" + i.getClname() + "</span>");
                out.write("<span>" + i.getSname() + "</span>");
                out.write("<span>" + i.getSsex() + "</span>");
                out.write("<span>" + i.getSage() + "</span>");
                out.write("<span>" + i.getGrade() + "</span>");
                out.write("<span>" + (no++) + "</span>");
                out.write("</div>");
            }
            out.write("</div>");
        }
        out.flush();
        out.close();
    }

    //查询所有课程
    protected void query_all_course(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        List<Course> results = new CourseDao().query_all_course();
        PrintWriter out = response.getWriter();
        if (results != null) {
            //输出结果
            out.write("<div class='all'>");
            out.write("<div><span>课程号</span><span>课程名称</span><span>执教老师</span><span>学分</span></div>");
            for (Course i : results) {
                out.write("<div>");
                out.write("<span>" + i.getCno() + "</span>");
                out.write("<span>" + i.getCname() + "</span>");
                out.write("<span>" + i.getCteacher() + "</span>");
                out.write("<span>" + i.getCcredit() + "</span>");
                out.write("</div>");
            }
            out.write("</div>");
        }
        out.flush();
        out.close();
    }

    //插入课程
    protected void insert_course(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer Cno = Integer.valueOf(request.getParameter("cno"));
        String Cname = request.getParameter("cname");
        String Cteacher = request.getParameter("cteacher");
        byte Ccredit = Byte.parseByte(request.getParameter("ccredit"));
        int status = new CourseDao().insert_course(Cno, Cname, Cteacher, Ccredit);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "课程" + Cname + "插入成功！";
        } else {
            info = "错误：课程插入失败！";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    //删除课程
    protected void delete_course(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer cno = Integer.valueOf(request.getParameter("cno"));
        int status = new CourseDao().delete_course(cno);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "成功删除" + cno + "课程！";
        } else {
            info = "错误：删除课程失败！";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    //修改课程信息
    protected void alter_course(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");

        Integer cno = Integer.valueOf(request.getParameter("cno"));
        Integer after_cno = Integer.valueOf(request.getParameter("after_cno"));
        String after_cname = request.getParameter("after_cname");
        String after_cteacher = request.getParameter("after_cteacher");
        byte after_ccredit = Byte.parseByte(request.getParameter("after_ccredit"));
        int status = new CourseDao().alter_course(cno, after_cno, after_cname, after_cteacher, after_ccredit);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = cno + "号课程修改成功！";
        } else {
            info = "错误：修改课程信息失败!";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    /*-------------------------------- 成绩-----------------------------------*/
    // 查询所有成绩表
    protected void query_all_sc(HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        ArrayList<SC> results = new SCDao().query_all_sc();
        PrintWriter out = response.getWriter();
        // 输出结果
        if (results != null) {
            out.write("<div id='all_sc' class='all'>");
            out.write("<div><span>学号</span><span>姓名</span><span>性别</span><span>年龄</span><span>课程号</span><span>课程名称</span><span>分数</span></div>");
            for (SC i : results) {
                out.write("<div>");
                out.write("<span>" + i.getSno() + "</span>");
                out.write("<span>" + i.getSname() + "</span>");
                out.write("<span>" + i.getSsex() + "</span>");
                out.write("<span>" + i.getSage() + "</span>");
                out.write("<span>" + i.getCno() + "</span>");
                out.write("<span>" + i.getCname() + "</span>");
                out.write("<span>" + i.getGrade() + "</span>");
                out.write("</div>");
            }
            out.write("</div>");
        }
        out.flush();
        out.close();
    }

    // 插入一条成绩记录
    protected void insert_sc(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer sno = Integer.valueOf(request.getParameter("sno"));
        Integer cno = Integer.valueOf(request.getParameter("cno"));
        float grade = Float.parseFloat(request.getParameter("grade"));
        int status = new SCDao().insert_sc(sno, cno, grade);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = sno + "号学生" + cno + "号课程成绩" + grade + "插入成功！";
        } else {
            info = "错误：成绩信息插入失败！";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    // 删除成绩记录
    protected void delete_sc(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer sno = Integer.valueOf(request.getParameter("sno"));
        Integer cno = Integer.valueOf(request.getParameter("cno"));
        int status = new SCDao().delete_sc(sno, cno);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = "成功删除" + sno + "号学生" + cno + "号课程成绩！";
        } else {
            info = "错误：删除成绩信息失败！";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

    // 修改成绩信息
    protected void alter_sc(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Integer sno = Integer.valueOf(request.getParameter("sno"));
        Integer cno = Integer.valueOf(request.getParameter("cno"));
        float after_grade = Float.parseFloat(request.getParameter("after_grade"));
        int status = new SCDao().alter_sc(sno, cno, after_grade);
        String info;
        PrintWriter out = response.getWriter();
        if (status == 1) {
            info = sno + "号学生" + cno + "号课程成绩修改成功！";
        } else {
            info = "错误：修改学生成绩失败!";
        }
        out.write("<div class='error'>");
        out.write("<div>" + info + "</div>");
        out.write("</div>");
        out.flush();
        out.close();
    }

}