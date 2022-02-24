package cn.edu.jit.wdnv.java.sims.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnect {
    private static final String dbUrl = "jdbc:mysql://r.sz1.nodes.wdksl.com:33068/db_student?useUnicode=true&characterEncoding=utf8"; // 数据库连接地址
    private static final String dbUserName = "user"; // 用户名
    private static final String dbPASS = "12345678"; // 密码
    private static final String dbDRIVER = "com.mysql.cj.jdbc.Driver"; // 驱动名称

    static Connection con;

    /**
     * 获取数据库连接
     *
     * @return
     * @throws Exception
     */
    public static Connection getCon() {
        try {
            Class.forName(dbDRIVER); //SetDriver
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(dbUrl, dbUserName, dbPASS);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }
}
