package edu.soft2.test;

import edu.soft2.dao.UsersDao;
import edu.soft2.entity.Users;

public class TestUsersDao {
    public static void main(String[] arge){
        Users user = new UsersDao().findUser("peter","123");
        System.out.println(user);
    }
}