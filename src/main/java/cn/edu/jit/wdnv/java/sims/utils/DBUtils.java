package cn.edu.jit.wdnv.java.sims.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    /**
     * 获取数据库连接
     *
     * @return Connection对象
     */
    protected final static String dbUser = "user";
    protected final static String dbPASSWD = "12345678";
    protected final static String dbURL = "jdbc:mysql://localhost:3306/stuinfo";
    private static Connection con;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, dbUser, dbPASSWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 关闭数据库连接
     *
     * @param con Connection对象
     */
    public static void closeCon(Connection con) {
        //判断conn是否为空
        if (con != null) {
            try {
                con.close();//关闭数据库连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
