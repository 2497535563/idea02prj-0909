package edu.soft.dao;

import edu.soft.pojo.Topic;

import java.util.List;

public class TopicDaoTest {
    public static void main(String[] args){
//        //1.获取方法返回值
//        List<Topic> list = new TopicDao().findAllTopic();
//        //2.打印返回值到控制台
//        for (Topic tmp:list){
//            System.out.println(tmp);
//        }


//        //2.测试findTopicByName()方法
//        List<Topic> list2 = new TopicDao().findTopicByName("天气");
//        //2.打印返回值到控制台
//        for (Topic tmp:list2){
//            System.out.println(tmp);
//        }

        //3.测试addTopic()方法
        boolean success1 = new TopicDao().addTopic("测试1");
        if (success1 == true){
            System.out.println("添加成功！");
        }else {
            System.out.println("添加失败！");
        }

//        //4.测试delTopic()方法
//        boolean success2 = new TopicDao().delTopic("测试一");
//        if (success2 == true){
//            System.out.println("删除成功！");
//        }else {
//            System.out.println("删除失败！");
//        }

//        //4.测试delTopic()方法
//        boolean success3 = new TopicDao().updateTopic("8","测试一");
//        if (success3 == true){
//            System.out.println("修改成功！");
//        }else {
//            System.out.println("修改失败！");
//        }


    }
}
