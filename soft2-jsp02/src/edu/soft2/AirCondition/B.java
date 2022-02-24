package edu.soft2.AirCondition;

public class B {
    String name;
    int age;

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected B clone() {
        B  b=null;
        try {
            b= (B) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return b;
    }
}
