package cn.edu.jit.wdnv.java.sims.dao;

import cn.edu.jit.wdnv.java.sims.beans.SC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SCDao extends BaseDao {

    // 获取所有成绩记录的信息，用ArrayList返回
    public ArrayList<SC> query_all_sc() {

        sql = "select student.Sno,Sname,Ssex,Sage,course.Cno,Cname,Grade from sc,student,course where sc.Sno = student.Sno and course.Cno = sc.Cno order by Sno;";
        ArrayList<SC> results = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SC sc = new SC(rs.getInt("sno"), rs.getString("sname"), rs.getString("ssex"), rs.getByte("sage"), rs.getInt("cno"), rs.getString("cname"), rs.getFloat("grade"));

                results.add(sc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    // 插入成绩信息，返回一个int值表示状态,1：成功，0失败
    public int insert_sc(Integer Sno, Integer Cno, float Grade) {
        status = 0;
        sql = "insert into sc values(?,?,?);";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Sno);
            ps.setInt(2, Cno);
            ps.setFloat(3, Grade);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            status = 0;
            e.printStackTrace();
        }
        return status;
    }

    // 删除成绩记录，返回一个int值表示状态,1：成功，0失败
    public int delete_sc(Integer Sno, Integer Cno) {

        sql = "delete from sc where sno = ? and cno = ?;";
        status = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Sno);
            ps.setInt(2, Cno);
            status = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    // 修改成绩信息，返回一个int值表示状态,1：成功，0失败
    public int alter_sc(Integer Sno, Integer Cno, float after_grade) {

        sql = "update sc set grade = ? where sno = ? and cno = ?;";
        status = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, after_grade);
            ps.setInt(2, Sno);
            ps.setInt(3, Cno);
            status = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

}
