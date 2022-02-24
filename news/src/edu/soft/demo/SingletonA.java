package edu.soft.demo;

/**
 * 饿汉
 */
public class SingletonA {
    private static final SingletonA s = new SingletonA();
    public static SingletonA getInstance(){
        return s;
    }
    public SingletonA(){

    }
}
