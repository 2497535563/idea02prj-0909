package edu.soft.demo;

/**
 * 测试单例模式
 */
public class SingletonTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            //饿汉
            System.out.println("饿汉" + (i + 1) + SingletonA.getInstance());
        }
        for (int i = 0; i < 5; i++) {
            //饿汉
            System.out.println("懒汉" + (i + 1) + SingletonB.getInstance());
        }
    }
}
