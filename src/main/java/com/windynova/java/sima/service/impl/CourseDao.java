package com.windynova.java.sima.service.impl;

import com.windynova.java.sima.mapper.CourseMapper;
import com.windynova.java.sima.entity.Course;
import com.windynova.java.sima.entity.CourseAvg;
import com.windynova.java.sima.entity.CourseFailRate;
import com.windynova.java.sima.entity.CourseRanking;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDao extends BaseDao {

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
    public int alter_course(Integer cno, Integer after_cno, String after_cname, String after_cteacher, float after_ccredit) {
        status = 0;
        sql = "update course set cno = ?,cname = ?,cteacher = ?,ccredit = ? where cno = ?;";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, after_cno);
            ps.setString(2, after_cname);
            ps.setString(3, after_cteacher);
            ps.setFloat(4, after_ccredit);
            ps.setInt(5, cno);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            status = 0;
            e.printStackTrace();
        }
        return status;
    }


    public ArrayList<CourseAvg> course_avg() {
        status = 0;
        sql = "select sc.Cno,Cname,course.Cteacher,course.Ccredit,avg(Grade) avg from course,sc where course.Cno = sc.Cno group by cno order by cno;";
        ArrayList<CourseAvg> course_avg = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CourseAvg courseAvg = new CourseAvg(rs.getInt("Cno"), rs.getString("Cname"), rs.getString("Cteacher"), rs.getByte("Ccredit"), rs.getFloat("avg"));
                course_avg.add(courseAvg);
            }
        } catch (SQLException e) {
            status = 0;
            e.printStackTrace();
        }
        return course_avg;
    }// 查询课程平均分信息 返回一个ArrayLst集合

    public ArrayList<CourseFailRate> fail_rate() { //查询课程不及格率
        status = 0;
        sql = "select cno,(select cname from course where cno = x.cno) cname,(select cteacher from course where cno = x.cno)cteacher ,(select ccredit from course where cno = x.cno)ccredit,cast(100.0*(select count(sno) from sc where grade < 60 and cno = x.cno)/(select count(sno) from sc where cno = x.cno) as decimal(18,2)) rate from sc x group by cno order by cno;";
        ArrayList<CourseFailRate> fail_rate = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CourseFailRate courseFailRate = new CourseFailRate(rs.getInt("cno"), rs.getString("cname"), rs.getString("Cteacher"), rs.getByte("Ccredit"), rs.getFloat("rate"));
                fail_rate.add(courseFailRate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fail_rate;
    }

    //查询课程排名情况,返回一个ArrayList集合
    public ArrayList<CourseRanking> course_ranking(Integer cno) {

        sql = "select student.Sno,Dname,Clname,Sname,Ssex,Sage,Grade from department,class,student,sc where student.sno = sc.sno and class.Clno = student.Clno and department.Dno = class.Dno and cno = '" + cno + "' order by grade desc;";
        ArrayList<CourseRanking> course_ranking = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CourseRanking courseRanking = new CourseRanking(rs.getInt("Sno"), rs.getString("Dname"), rs.getString("Clname"), rs.getString("Sname"), rs.getString("Ssex"), rs.getByte("Sage"), rs.getFloat("Grade"));
                course_ranking.add(courseRanking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return course_ranking;
    }
}

