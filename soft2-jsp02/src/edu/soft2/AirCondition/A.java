package edu.soft2.AirCondition;

public class A {
    public static void main(String[] arge){
        B b = new B();//原型
        b.name = "DollyPrototype";
        b.age =10;
        System.out.println(b);//原型对象打印
        B b1 = b.clone();
        System.out.println(b1);//克隆对象打印
        B b2 = b.clone();
        System.out.println(b2);//克隆对象打印

        System.out.println(new B());//new创建对象打印
  }
}
