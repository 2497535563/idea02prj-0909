package edu.soft2.AirCondition;

import edu.soft2.designFactory.Factory;

public class Test {
    public static void main(String[] args) {


        AirFactory airFactory = new MideaAirFactory();//创建工厂，注入对象
        Air air = airFactory.ProductAir();//(工厂调用)生产产品的方法，获取产品对象
        air.work();
    }
}
