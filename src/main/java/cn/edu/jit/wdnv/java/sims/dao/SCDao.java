package cn.edu.jit.wdnv.java.sims.dao;

import cn.edu.jit.wdnv.java.sims.model.SC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SCDao extends BaseDao {

    // 获取所有成绩记录的信息，用ArrayList返回
    public ArrayList<SC> query_all_sc() {

        String sql = "select student.sno,sno,sname,ssex,sage,course.cno,cname,grade from sc,student,course where sc.sno = student.sno and course.cno = sc.cno order by sno;";
        ArrayList<SC> results = new ArrayList<>();
        try(PreparedStatement ps =con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SC sc = new SC(rs.getString("sno"),rs.getString("sname"),rs.getString("ssex"),rs.getInt("sage"),rs.getString("cno"),rs.getString("cname"),rs.getDouble("grade"));

                results.add(sc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return results;
    }

    // 插入成绩信息，返回一个int值表示状态,1：成功，0失败
    public int insert_sc(String Sno, String Cno, double Grade) {
        status=0;
        String sql = "insert into sc values(?,?,?);";

        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, Sno);
            ps.setString(2, Cno);
            ps.setDouble(3, Grade);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            status=0;
            e.printStackTrace();
        } 
        return status;
    }

    // 删除成绩记录，返回一个int值表示状态,1：成功，0失败
    public int delete_sc(String Sno, String Cno) {

        String sql = "delete from sc where sno = ? and cno = ?;";
        status = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, Sno);
            ps.setString(2, Cno);
            status = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return status;
    }

    // 修改成绩信息，返回一个int值表示状态,1：成功，0失败
    public int alter_sc(String Sno, String Cno, double after_grade) {

        String sql = "update sc set grade = ? where sno = ? and cno = ?;";
        status = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, after_grade);
            ps.setString(2, Sno);
            ps.setString(3, Cno);
            status = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return status;
    }

}
