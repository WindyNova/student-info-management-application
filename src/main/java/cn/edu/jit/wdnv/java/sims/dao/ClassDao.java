package cn.edu.jit.wdnv.java.sims.dao;

import cn.edu.jit.wdnv.java.sims.model.Class;
import cn.edu.jit.wdnv.java.sims.utils.DBUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDao {
    int status;
    // 获取所有班级的信息，用ArrayList返回
    public List<Class> query_all_class() {
        ArrayList<Class> results = new ArrayList<>();
        try {
 
            while (rs.next()) {
                Class temp = new Class();
                temp.setClno(rs.getString("clno"));
                temp.setClname(rs.getString("clname"));
                temp.setDno(rs.getString("dno"));
                results.add(temp);
            }

        } catch (SQLException e) {
            status = 0;
            e.printStackTrace();
        }
        return results;
    }

    // 插入班级信息，返回一个int值表示状态,1：成功，0失败
    public int insert_class(String clno, String clname, String dno) {
        String sql = "insert into class values(?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, clno);
            ps.setString(2, clname);
            ps.setString(3, dno);
            status = ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException e) {
            status = 0;
            e.printStackTrace();
        }
        return status;
    }

    // 删除班级信息，返回一个int值表示状态,1：成功，0失败
    public int delete_class(String clno) {
        String sql = "delete from class where clno = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, clno);
            status = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            status = 0;
            e.printStackTrace();
        } finally {
            DBUtils.closeCon(con);
        }
        return status;
    }

    // 修改班级信息，返回一个int值表示状态,1：成功，0失败
    public int alter_class(String clno, String after_clno, String after_clname, String after_dno) {
        String sql = "update class set clno = ?,clname = ?,dno = ? where clno = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, after_clno);
            ps.setString(2, after_clname);
            ps.setString(3, after_dno);
            ps.setString(4, clno);
            status = ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            status = 0;
            e.printStackTrace();
        } finally {
            DBUtils.closeCon(con);
        }
        return status;
    }

}
