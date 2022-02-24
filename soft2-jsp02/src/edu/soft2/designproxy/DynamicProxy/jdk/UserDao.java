package edu.soft2.designproxy.DynamicProxy.jdk;

public class UserDao implements Dao {
    @Override
    public void add() {
        System.out.println("数据的增操作");
    }

    @Override
    public void delete() {
        System.out.println("数据的增删操作");
    }

    @Override
    public void update() {
        System.out.println("数据的改操作");
    }

    @Override
    public void query() {
        System.out.println("数据的查操作");
    }
}
