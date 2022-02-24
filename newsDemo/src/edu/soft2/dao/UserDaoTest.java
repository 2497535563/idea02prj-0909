package edu.soft2.dao;

public class UserDaoTest {
    public static void main(String[] args) {
    UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.findUser("peter","123"));
    }
}
