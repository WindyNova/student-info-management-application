package cn.edu.jit.wdnv.java.sims.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    /**
     * 获取数据库连接
     */
    private final static String dbUser = "user";
    private final static String dbPASSWD = "12345678";
    private final static String deploymentIP = "172.17.0.1";
    private final static String localhostIP = "127.0.0.1";
    private final static String dbURL = "jdbc:mysql://" + deploymentIP + ":3306/stuinfo";
    protected static Connection con;

    static {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, dbUser, dbPASSWD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
