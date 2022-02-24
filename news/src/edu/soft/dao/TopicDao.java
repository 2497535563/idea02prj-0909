package edu.soft.dao;

import edu.soft.pojo.Topic;
import edu.soft.util.DaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *topic表的增删改查
 */
public class TopicDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * 查询所有topic
     * @return
     */
    public List<Topic> findAllTopic() {
        List<Topic> list = new ArrayList<Topic>();
        //1,连接数据库
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("select * from topic");
            //2,查询结果
            rs = ps.executeQuery();
            //3,解析结果集
            while (rs.next()) {
                //封装为Topic对象
                Topic topic = new Topic(
                        rs.getString("tid"),
                        rs.getString("tname")
                );
                //4.Tope对象添加至返回值list中
                list.add(topic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;//返回结果
    }

    /**
     * 根据tname查询topic
     */
    public List<Topic> findTopicByName(String tname) {
        List<Topic> list = new ArrayList<Topic>();
        //1,连接数据库
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("select * from topic where tname = ?");
            ps.setString(1, tname);
            //2,查询结果
            rs = ps.executeQuery();
            //3,解析结果集
            while (rs.next()) {
                //封装为Topic对象
                Topic topic = new Topic(
                        rs.getString("tid"),
                        rs.getString("tname")
                );
                //4.Tope对象添加至返回值list中
                list.add(topic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 添加一个topic
     * @param tname
     * @return
     */
    public boolean addTopic(String tname){
        boolean flag = false;
        int rows = 0;
        //1,连接数据库
        conn = DaoFactory.getConn();
        System.out.println("finally");
        try {
            ps = conn.prepareStatement("insert into topic(tname) values(?);");
            ps.setString(1, tname);
            rows = ps.executeUpdate();
            //获取返回值
            if (rows!=0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 删除一个topic
     */
    public boolean delTopic(String tid){
        boolean flag = false;
        int rows = 0;
        conn = DaoFactory.getConn();
        try {
            ps = conn.prepareStatement("delete from topic where tid = ?");
            ps.setString(1,tid);
            rows = ps.executeUpdate();
            if(rows!=0){
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;

    }

/**
 *修改topic
 */
public boolean updateTopic(String tid,String tname){
    boolean flag = false;
    int rows = 0;
    conn = DaoFactory.getConn();
    try {
        ps = conn.prepareStatement("update topic set tname = ? where tid = ?");
        ps.setString(1,tname);
        ps.setString(2,tid);
        rows = ps.executeUpdate();
        if (rows!= 0){
            flag = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return flag;
}
}
