package cn.edu.jit.wdnv.java.sims.dao;

import cn.edu.jit.wdnv.java.sims.model.Course;
import cn.edu.jit.wdnv.java.sims.model.Course_avg;
import cn.edu.jit.wdnv.java.sims.model.Course_fail_rate;
import cn.edu.jit.wdnv.java.sims.model.Course_ranking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDao extends BaseDao{

    public ArrayList<Course> query_all_course() { // 获取所有课程的信息，用ArrayList返回
        String sql = "select * from course order by cno;";
        ArrayList<Course> results = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course(rs.getString("Cno"),rs.getString("Cname"),rs.getString("Cteacher"),rs.getInt("Ccredit"));
                results.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public int insert_course(String Cno, String Cname, String Cteacher, double Ccredit) { // 插入课程信息
       status = 0;
        String sql = "insert into course values(?,?,?,?);";
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, Cno);
            ps.setString(2, Cname);
            ps.setString(3, Cteacher);
            ps.setDouble(4, Ccredit);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            status = 0 ;
            e.printStackTrace();
        } 
        return status;
    }

    public int delete_course(String Cno) {
        status =0 ;
        String sql = "delete from course where Cno = ?;";
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, Cno);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            status =0 ;
            e.printStackTrace();
        } 
        return status;
    } // 删除课程信息

    //修改课程信息
    public int alter_course(String cno, String after_cno, String after_cname, String after_cteacher, double after_ccredit) {
        status =0 ;
        String sql = "update course set cno = ?,cname = ?,cteacher = ?,ccredit = ? where cno = ?;";
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, after_cno);
            ps.setString(2, after_cname);
            ps.setString(3, after_cteacher);
            ps.setDouble(4, after_ccredit);
            ps.setString(5, cno);
            status = ps.executeUpdate();
        } catch (SQLException e) {
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

