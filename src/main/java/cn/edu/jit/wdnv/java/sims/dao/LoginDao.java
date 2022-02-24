package cn.edu.jit.wdnv.java.sims.dao;

import cn.edu.jit.wdnv.java.sims.model.Admin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginDao extends BaseDao {
    int status;
    public int login(Admin admin) {
        try {
            String sql = "select * from s_users where name=? and password=?";
            PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
            prst.setString(1, admin.getName());
            prst.setString(2, admin.getPassword());
            status = prst.executeUpdate();
            con.close();
        } catch (SQLException e) {
            status = 0;
        }
        return status;
    }
    public void setCredentials(String userName, String password) {
    }
}
