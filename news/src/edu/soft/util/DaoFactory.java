package edu.soft.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

/**
 * 打开数据库连接以及关闭数据库连接
 */
public class DaoFactory {
    private static Connection conn = null;
    /**
     * 打开数据库连接
     * @return
     */
    public static Connection getConn() {
        if (conn == null) {
        try {
           /* Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/qqZone");
            conn = ds.getConnection();
            System.out.println("conn = " + conn);*/

            PropertiesManager pro = PropertiesManager.getInstance();
            String driver = pro.getString("jdbc.driver_class");
            String url = pro.getString("jdbc.connection.url");
            String username = pro.getString("jdbc.connection.username");
            String pwd = pro.getString("jdbc.connection.password");
                Class.forName(driver);//5.x版本的mysql
            conn = (Connection) DriverManager.getConnection(url,username,pwd);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
        return conn;
    }

       /* try {
            Class.forName("com.mysql.jdbc.Driver");//5.X版本的mysql
//			Class.forName("com.mysql.cj.jdbc.Driver");//8.0版本的mysql
            conn = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/news?"
                            + "useUnicode=true&characterEncoding=utf-8"
                            + "&useSSL=false&serverTimezone=Asia/Shanghai",
                    "root",
                    "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }*/
    /**
     *关闭数据库连接
     */
    public static void closeConn(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if (rs!=null) rs.close();
            if (ps!=null) ps.close();
            if (conn!=null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

