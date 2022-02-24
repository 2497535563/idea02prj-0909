package edu.soft2.AirCondition;

import edu.soft2.AirCondition.Air;
import edu.soft2.AirCondition.GreeAir;
import edu.soft2.AirCondition.AirFactory;

public class GreeAirFactory implements AirFactory {
    @Override
    public Air ProductAir() {
        System.out.println("格力工厂开工制造");
        return new GreeAir();
    }
}
