package edu.soft.dao;

import edu.soft.pojo.User;
import edu.soft.util.DaoFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *访问操作news_user表的dao表
 */
public class UsereDao {
    public User findUser(String username, String upwd){
        User user = null;
        String sql = "select * from news_user where username=? and upwd=?";
        //1.获取连接对象
        Connection conn = DaoFactory.getConn();
        try{
            //2.获取PreparedStatement(司机)对象
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,upwd);
            //3.获取结果集
            ResultSet rs = ps.executeQuery();
            //4.解析结果集封装（组装）成为一个User对象
            while (rs.next()){//true:查询到结果
                System.out.println("查询到用户");
                user = new User(
                            rs.getString("uid"),
                            rs.getString("username"),
                            rs.getString("upwd")
                            );
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user;
    }

    /**
     *通过用户名查询用户
     * @param username
     * @return
     */
    public int findUserByName(String username){
        int flag = 0;
        String sql = "select * from news_user where username = ?";//占位符
        Connection conn = DaoFactory.getConn();
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                flag = 1;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("findUserName返回值="+flag);
        return flag;//0:无此用户，1：有此用户
    }


    public boolean addUser(String username ,String upwd ){
        boolean flag = false;
        Connection conn = DaoFactory.getConn();
        String sql="insert into news_user(username,upwd) values(?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,upwd);
            flag = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
