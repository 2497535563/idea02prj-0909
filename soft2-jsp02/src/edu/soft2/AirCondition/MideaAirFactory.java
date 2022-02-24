package edu.soft2.AirCondition;

import edu.soft2.AirCondition.Air;
import edu.soft2.AirCondition.MideaAir;
import edu.soft2.AirCondition.AirFactory;

public class MideaAirFactory implements AirFactory {
    @Override
    public Air ProductAir() {
        System.out.println("美的工厂开工制造");
        return new MideaAir();
    }
}
