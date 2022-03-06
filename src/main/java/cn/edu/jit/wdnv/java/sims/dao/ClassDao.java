package cn.edu.jit.wdnv.java.sims.dao;

import cn.edu.jit.wdnv.java.sims.model.Class;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClassDao extends BaseDao{

    public ArrayList<Class> query_all_class() {
        String sql = "select * from class order by clno;";
        ArrayList<Class> results = new ArrayList<>();
        try ( PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Class Class = new Class(rs.getString("clno"),rs.getString("clname"),rs.getString("dno"));
                results.add(Class);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    } // 获取所有班级的信息，用ArrayList返回


    public int insert_class(String clno, String clname, String dno) { // 插入班级信息
        status=0;
        String sql = "insert into class values(?,?,?);";
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, clno);
            ps.setString(2, clname);
            ps.setString(3, dno);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            status =0;
            e.printStackTrace();
        }
        return status;
    }


    public int delete_class(String clno) { // 删除班级信息
        status=0;
        String sql = "delete from class where clno = ?;";
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, clno);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            status =0;
            e.printStackTrace();
        }
        return status;
    }


    public int alter_class(String clno, String after_clno, String after_clname, String after_dno) {   // 修改班级信息
        status =0;
        String sql = "update class set clno = ?,clname = ?,dno = ? where clno = ?;";
        try (PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1, after_clno);
            ps.setString(2, after_clname);
            ps.setString(3, after_dno);
            ps.setString(4, clno);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            status =0;
            e.printStackTrace();
        }
        return status;
    }

}
