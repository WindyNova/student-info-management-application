package cn.edu.jit.wdnv.java.sims.dao;

import cn.edu.jit.wdnv.java.sims.model.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartmentDao extends BaseDao {
    //查询所有的系信息，查询返回一个含值的ArrayList,当为空值的说明表中无数据元组
    public ArrayList<Department> query_all_department() {
        sql = "select * from department order by dno;";
        ArrayList<Department> results = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Department department = new Department(rs.getInt("Dno"), rs.getString("Dname"));
                results.add(department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    //插入院系信息
    public int insert_department(Integer dno, String dname) {
        status = 0;
        sql = "insert into department values(?,?);";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dno);
            ps.setString(2, dname);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            status = 0;
            e.printStackTrace();
        }
        return status;
    }

    //删除院系信息
    public int delete_department(Integer dno) {
        status = 0;
        sql = "delete from department where dno = ?;";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dno);
            status = ps.executeUpdate();

        } catch (SQLException e) {
            status = 0;
            e.printStackTrace();
        }
        return status;
    }

    //修改院系信息
    public int alter_department(Integer dno, Integer after_dno, String after_dname) {
        status = 0;
        sql = "update department set dno = ?,dname = ? where dno = ?;";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, after_dno);
            ps.setString(2, after_dname);
            ps.setInt(3, dno);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            status = 0;
            e.printStackTrace();
        }
        return status;
    }

}
