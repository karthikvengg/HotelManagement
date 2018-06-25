package com.sahajhotels.structures;

import com.sahajhotels.appliances.AC;
import com.sahajhotels.appliances.Light;

public class MainCorridor {
    private Light light;
    private AC ac;
    private int mainCorridorNum;
    private boolean movement = false;
    private final int powerThreshold = 15;

    public MainCorridor(int mainCorridorNum) {
        light = new Light(5,"ON");
        ac = new AC(10,"ON");
        this.mainCorridorNum = mainCorridorNum;
    }

    public AC getAc() {
        return ac;
    }

    public int getMainCorridorNum() {
        return mainCorridorNum;
    }

    public void getStatus(){
        System.out.print("Light 1 : " + light.getState() + " AC : " + ac.getState());
    }

    public int getPowerConsumption(){
        return light.getPower() + ac.getPower();
    }

    public int getPowerThreshold() {
        return powerThreshold;
    }

    public boolean isMovement() {
        return movement;
    }
}
