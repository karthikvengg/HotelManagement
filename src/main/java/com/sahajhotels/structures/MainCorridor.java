package com.sahajhotels.structures;

import com.sahajhotels.appliances.AC;
import com.sahajhotels.appliances.Appliance;
import com.sahajhotels.appliances.Light;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MainCorridor {

    private Appliance light;
    private Appliance ac;
    private int mainCorridorNum;
    private boolean movement = false;

    public MainCorridor() {
        light = new Light();
        ac = new AC();
    }

    public MainCorridor(int mainCorridorNum) {
        light = new Light();
        ac = new AC();
        this.mainCorridorNum = mainCorridorNum;
    }
    public void getStatus(){
        System.out.print("Light 1 : " + light.getState() + " AC : " + ac.getState());
    }

    public int getPowerConsumption(){
        return light.getPower() + ac.getPower();
    }

    public int getPowerThreshold() {
        int powerThreshold = 15;
        return powerThreshold;
    }

}
