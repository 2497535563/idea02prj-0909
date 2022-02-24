package edu.soft2.test;

import edu.soft2.dao.GoodsDao;
import edu.soft2.entity.Goods;

import java.util.ArrayList;
import java.util.List;

//Goods的测试类
public class TestGoodsDao {
    public static void main(String[] args) {
        List<Goods> list = new ArrayList<Goods>();
        list = new GoodsDao().queryAllGoods();//接受方法返回值
        //打印list中的goods对象(toString()方法)
        for (Goods goods:list) {
            System.out.println(goods);
        }
    }
}
