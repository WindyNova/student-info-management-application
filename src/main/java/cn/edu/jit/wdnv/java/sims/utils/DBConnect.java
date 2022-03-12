package cn.edu.jit.wdnv.java.sims.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    /**
     * 获取数据库连接
     */
	
	private final static String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final static String dbUser = "sa";
    private final static String dbPASSWD = "123456";
    private final static String dbIP ="127.0.0.1";
    private final static String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=stuinfo";
    protected static Connection con;

    static {

        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(dbURL, dbUser, dbPASSWD);
            System.out.println("Success!");
        } catch (ClassNotFoundException | SQLException e) {
        	System.out.println("Fail");
            e.printStackTrace();
        }
    }

}
