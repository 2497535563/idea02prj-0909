package edu.soft.dao;

import edu.soft.pojo.News;

import java.util.List;

public class NewsDaoTest {

    public static void main(String[] args){
        //测试findAllNews()方法
        List<News> allNews = new NewsDao().findAllNews();
        for (News news:allNews){
            System.out.println(news);
        }
        System.out.println("***************");
        //测试findAllNewsById()方法
        List<News> News = new NewsDao().findNewsById("1");
        for (News n:News){
            System.out.println(n);
        }
    }
}
