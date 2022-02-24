package edu.soft2.service;

import edu.soft2.entity.Category;
import edu.soft2.tools.DBHelp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Index2 {
    public static void main(String[] args)  {
        //1.获取数据库连接对象
        Connection conn = new DBHelp().getConn();
        //2.获取Statement对象
//  Statement st = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from category;");
//   st = conn.createStatement();
            //3.Statement对象执行sql语句，获取查询结果集
//   rs = st.executeQuery("select * from category;");//7行数据
            rs = ps.executeQuery();
            //4.对ResultSet结果集解析，打印到控制台
            int i= 1;
            while(rs.next()) {//获取ResultSet结果集的每一行数据
                //5.获取当前行(条)数据的第i列,并组装category对象
                Category cate = new Category();//属性值为null
//   String cateID = rs.getString(1);//解析结果集，获取cateID的值
                String cateID = rs.getString("cateID");
                cate.setCateID(cateID);
//   String cateName = rs.getString(2);
                String cateName = rs.getString("cateName");
                cate.setCateName(cateName);
                System.out.println("第"+i+"条数据为"+cate);
//   System.out.println("第"+i+"条数据为"+cateID+"和"+cateName);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ((ResultSet) rs).close();//关闭结果集ResultSet对象
                ps.close();//关闭Statement对象
                conn.close();//关闭Connection连接对象
            }catch (SQLException e2) {

            }
        }
    }
}
