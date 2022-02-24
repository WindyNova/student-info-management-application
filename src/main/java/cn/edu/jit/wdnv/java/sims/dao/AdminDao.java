package cn.edu.jit.wdnv.java.sims.dao;

import cn.edu.jit.wdnv.java.sims.model.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends BaseDao { //登录DAO层

    public String editPassword(Admin admin, String newPassword) {
        String sql = "select * from s_admin where id=? and password=?";
        PreparedStatement prst = null;
        int id = 0;
        try {
            prst = con.prepareStatement(sql);
            prst.setInt(1, admin.getId());
            prst.setString(2, admin.getPassword());
            ResultSet executeQuery = prst.executeQuery();
            if (!executeQuery.next()) {
                String retString = "旧密码错误！";
                return retString;
            }
            id = executeQuery.getInt("id");
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }//把sql语句传给数据库操作对象
        String retString = "修改失败";
        String sqlString = "update s_admin set password = ? where id = ?";
        try {
            prst = con.prepareStatement(sqlString);
            prst.setString(1, newPassword);
            prst.setInt(2, id);
            int rst = prst.executeUpdate();
            if (rst > 0) {
                retString = "密码修改成功！";
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//把sql语句传给数据库操作对象
        return retString;
    }
}
