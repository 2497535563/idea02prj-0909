package edu.soft.dao;/*
package edu.soft.dao;

import edu.soft.pojo.News;
import edu.soft.util.DaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDaoImpl NewsDao{
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    */
/* 查询所有新闻
     * @return
     *//*


    public List<News> findAllNews() {
        List<News> list = new ArrayList<News>();
        String sql = "select * from news";
        //1.连接数据库
        Connection conn = DaoFactory.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //2.执行查询，获取结果集
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            //3.解析结果集，每一条数据封装人一个News对象，并将其添加到list中
            while (rs.next()){
                News news = new News(
                        rs.getInt("nId")+"",
                        rs.getInt("nTid")+"",
                        rs.getString("nTitle"),
                        rs.getString("nAuthor"),
                        rs.getString("nCreateDate"),
                        rs.getString("nPicPath"),
                        rs.getString("nContent"),
                        rs.getString("nModifyDate"),
                        rs.getString("nSummary"));
                list.add(news);//添加到list集合中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
finally {
                DaoFactory.closeConn(conn,ps,rs);
            }

        return list;
    }

*/
/*
  *获取New记录总数
 *
 *//*


    public int getTotalCount(){
        System.out.println("进入getTotalCount");
        int count = 0;
        String sql = "select count(*) from news";

try {
    conn = DaoFactory.getConn();
    ps = conn.prepareStatement(sql);
    rs = ps.executeQuery();
    while (rs.next()) {
        count = Integer.parseInt(rs.getObject(1).toString());
    }
    System.out.println("count="+count);
}catch (SQLException e){
    e.printStackTrace();
}
return count;
    }

*/
/*
     * 当前的newsList集合
     * @param currPageNo  当前页码
     *@param pageSize 每页记录数
     * @return 当前页News对象

*//*


    public List<News> getPageNewsList(int currPageNo,int pageSize) {
        List<News> newsList = new ArrayList<News>();
        String sql = "select * from news limit" + (currPageNo-1)*pageSize + "," +pageSize;
        System.out.println("sql="+sql);
        try {
           conn = DaoFactory.getConn();
           ps = conn.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()){
               rs.getInt("nId")+"",
                        rs.getInt("nTid")+"",
                        rs.getString("nTitle"),
                        rs.getString("nAuthor"),
                        rs.getString("nCreateDate"),
                        rs.getString("nPicPath"),
                        rs.getString("nContent"),
                        rs.getString("nModifyDate"),
                        rs.getString("nSummary")));}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;
    }
}
*/
