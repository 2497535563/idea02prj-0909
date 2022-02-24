package edu.soft2.dao;

import edu.soft2.entity.Users;
import edu.soft2.tools.DBHelp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Users数据表的访问
 */
public class UsersDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * 查询用户录入的账号、密码是否正确
     * @param id
     * @param pwd
     * @return
     */
    public Users findUser(String id, String pwd){
        Users users = null;
        //1.获取数据库连接对象
        conn = DBHelp.getConn();
        //2.获取PreparedStatement对象
        try {
            ps = conn.prepareStatement("select * from users where id = ? and pwd = ?;");
            ps.setString(1,id);
            ps.setString(2,pwd);
            //3.获取查询结果
            ResultSet rs = ps.executeQuery();
            //4.判定：有结果，则封装为Users对象；若无，则Users不赋值，依然置空
            while(rs.next()){//next方法的返回值为true或false
                //组装一个Users对象(全参数的构造方法)
                users = new Users(
                        rs.getString("id"),
                        rs.getString("pwd"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;//null/Users对象



    }
}