package edu.soft2.service;

import java.sql.*;


import edu.soft2.entity.Goods;
import edu.soft2.tools.DBHelp;

public class Index {

    public static void main(String[] args) throws SQLException {
        //获取数据库连接对象
        Connection conn = new DBHelp().getConn();
        //获取Statement对象
        Statement st = conn.createStatement();
        //Statement对象执行sql语句，获取查询结果集
        String sql = "select * from goods where goodsid = 11;";
        ResultSet rs = st.executeQuery(sql);
        //解析ResultSet类型的结果集(蚂蚁上树)
        while(rs.next()) {
            //1.创建Goods对象
            Goods goods = new Goods();
            //2.组装Goods对象
            String goodsid = rs.getString(1);//解析结果集，获取goodsid的值
            goods.setGoodsid(goodsid);//将goodsid的 值赋值给Goods对象的属性
            String title = rs.getString(2);//解析结果集，获取title的值
            goods.setTitle(title);//将title的 值赋值给Goods对象的属性
            String unitPrice = rs.getString(3);//解析结果集，获取UnitPrice的值
            goods.setUnitPrice(unitPrice);//将UnitPrice的 值赋值给Goods对象的属性
            String discount = rs.getString(4);//解析结果集，获取Discount的值
            goods.setDiscount(discount);;//将Discount的 值赋值给Goods对象的属性
            //打印组装完毕的goods对象(调用toString方法)
            System.out.println(goods.toString());
        }

    }

}