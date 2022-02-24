package edu.soft2.AirCondition;

/**
 * 单例模式(原则)
 */

public class Singleton {
    private String name;
    private int age;
    static Singleton instance;//原则1:静态化对象
    private  Singleton() {super();}//原则2:私有化构造方法
    public static Singleton getInstance(){//原则3:返回实列对象的公共方法
        if(instance == null) {
            instance = new Singleton();
        }
        return  instance;
    }

    public static void main(String[] args) {
        Singleton s1,s2;
        s1 = Singleton.getInstance();//调用静态方法
        s2 = Singleton.getInstance();//调用静态方法
        System.out.println("s1="+s1);
        System.out.println("s2="+s2);
        System.out.println("s1==s2结果:"+(s1==s2));
    }

    /*@Override
    public String toString() {
        return "Singleton{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/
}
