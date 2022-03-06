package cn.edu.jit.wdnv.java.sims.dao;

import cn.edu.jit.wdnv.java.sims.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao extends BaseDao{

    public ArrayList<Student> query_all_student() {     // 获取所有学生的信息，用ArrayList返回
        String sql = "select * from student order by sno;";
        ArrayList<Student> results = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student(rs.getString("sno"),rs.getString("sname"),rs.getString("ssex"),rs.getInt("sage"),rs.getString("clno"));
                results.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return results;
    }

    // 插入学生信息，返回一个int值表示状态,1：成功，0失败
    public int insert_student(String Sno, String Sname, String Ssex, int Sage, String Clno) {
        String sql = "insert into student values(?,?,?,?,?);";
        status = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, Sno);
            ps.setString(2, Sname);
            ps.setString(3, Ssex);
            ps.setInt(4, Sage);
            ps.setString(5, Clno);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return status;
    }

    // 删除学生信息，返回一个int值表示状态,1：成功，0失败
    public int delete_student(String sno) {
        String sql = "delete from student where sno = ?;";
        status = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sno);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return status;
    }

    // 修改学生信息，返回一个int值表示状态,1：成功，0失败
    public int alter_class(String sno, String after_sno, String after_sname, String after_ssex, int after_sage, String after_clno) {
        String sql = "update student set sno = ?,sname = ?,ssex = ?,sage = ?,clno = ? where sno = ?;";
        status = 0;
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, after_sno);
            ps.setString(2, after_sname);
            ps.setString(3, after_ssex);
            ps.setInt(4, after_sage);
            ps.setString(5, after_clno);
            ps.setString(6, sno);
            status = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return status;
    }

}
