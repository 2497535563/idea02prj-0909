package edu.soft2.designFactory;

public class FactoryA extends Factory {

    @Override
    public Product manufacture() {
        System.out.println("A工厂生产");
        return new ProductX();
    }
}
