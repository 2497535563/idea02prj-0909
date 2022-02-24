package edu.soft2.AirCondition;

import edu.soft2.AirCondition.Air;
import edu.soft2.AirCondition.HaierAir;
import edu.soft2.AirCondition.AirFactory;

public class HaierAirFactory implements AirFactory {
    @Override
    public Air ProductAir() {
        System.out.println("海尔工厂开工制造");
        return new HaierAir();
    }
}
