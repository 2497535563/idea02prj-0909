package edu.soft.dao;

import edu.soft.pojo.User;

/**
 * UserDao测试类
 */
public class UserDaoTest {
    public static void main(String[] args){
        User user = new UsereDao().findUser("peter","123");
        System.out.println("获取user对象="+user);
    }

}
