package cn.edu.jit.wdnv.java.sims.dao;

import cn.edu.jit.wdnv.java.sims.mapper.ClassMapper;
import cn.edu.jit.wdnv.java.sims.mapper.CourseMapper;
import cn.edu.jit.wdnv.java.sims.model.Class;
import cn.edu.jit.wdnv.java.sims.model.Course;
import cn.edu.jit.wdnv.java.sims.model.Course_avg;
import cn.edu.jit.wdnv.java.sims.model.Course_fail_rate;
import cn.edu.jit.wdnv.java.sims.model.Course_ranking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao extends BaseDao{

    public List<Course> query_all_course() { // 获取所有课程的信息，用ArrayList返回
        List<Course> results = new ArrayList<>();
        try {
            results = getSqlSession().getMapper(CourseMapper.class).selectAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }

    public int insert_course(String Cno, String Cname, String Cteacher, short Ccredit) { // 插入课程信息
       status = 0;
        try {
            Course course =new Course();
            course.setCno(Cno);
            course.setCname(Cname);
            course.setCteacher(Cteacher);
            course.setCcredit(Ccredit);
            status = getSqlSession().getMapper(CourseMapper.class).insert(course);
        } catch (Exception e) {
            status = 0 ;
            e.printStackTrace();
        } 
        return status;
    }

    public int delete_course(String Cno) {
        status = 0 ;
        try {
            status = getSqlSession().getMapper(CourseMapper.class).deleteByPrimaryKey(Cno);
        } catch (Exception e) {
            status =0 ;
            e.printStackTrace();
        } 
        return status;
    } // 删除课程信息

    //修改课程信息
    public int alter_course(String cno, String after_cno, String after_cname, String after_cteacher, Short after_ccredit) {
        status =0 ;

        try {
            Course course=new Course();
            course.setCno(after_cno);
            course.setCname(after_cname);
            course.setCcredit(after_ccredit);
            course.setCteacher(after_cteacher);
            status = getSqlSession().getMapper(CourseMapper.class).updateByPrimaryKey(course);
        } catch (Exception e) {
            status = 0;
            e.printStackTrace();
        } 
        return status;
    }


    public ArrayList<Course_avg> course_avg() {
        status =0;
        String sql = "select sc.cno,cno,cname,avg(grade) avg from course,sc where course.cno = sc.cno group by cno order by cno;";
        ArrayList<Course_avg> course_avg = new ArrayList<>();
        try ( PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course_avg courseAvg = new Course_avg(rs.getString("Cno"),rs.getString("Cname"),rs.getDouble("avg"));
                course_avg.add(courseAvg);
            }
        } catch (SQLException e) {
            status=0;
            e.printStackTrace();
        } 
        return course_avg;
    }// 查询课程平均分信息 返回一个ArrayLst集合

    public ArrayList<Course_fail_rate> fail_rate() { //查询课程不及格率
        status=0;
        String sql = "select cno,(select cname from course where cno = x.cno) cname,cast(100.0*(select count(sno) from sc where grade < 60 and cno = x.cno)/(select count(sno) from sc where cno = x.cno) as decimal(18,2)) rate from sc x group by cno order by cno;";
        ArrayList<Course_fail_rate> fail_rate = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course_fail_rate courseFailRate = new Course_fail_rate(rs.getString("cno"),rs.getString("cname"),rs.getDouble("rate"));
                fail_rate.add(courseFailRate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return fail_rate;
    }

    //查询课程排名情况,返回一个ArrayList集合
    public ArrayList<Course_ranking> course_ranking(String cno) {

        String sql = "select student.Sno,Sno,Dname,Clname,Sname,Ssex,Sage,Grade from department,class,student,sc where student.sno = sc.sno and class.Clno = student.Clno and department.Dno = class.Dno and cno = '" + cno + "' order by grade desc;";
        ArrayList<Course_ranking> course_ranking = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course_ranking courseRanking = new Course_ranking(rs.getString("Sno"),rs.getString("Dname"),rs.getString("Clname"),rs.getString("Sname"),rs.getString("Ssex"),rs.getInt("Sage"),rs.getDouble("Grade"));
                course_ranking.add(courseRanking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return course_ranking;
    }
}

