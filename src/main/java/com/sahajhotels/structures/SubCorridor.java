package com.sahajhotels.structures;

import com.sahajhotels.appliances.AC;
import com.sahajhotels.appliances.Light;

public class SubCorridor {
    public static final int POWER_PER_LIGHT = 5;
    public static final int POWER_PER_AC = 10;
    public static final String OFF = "OFF";
    public static final String ON = "ON";
    private Light light;
    private AC ac;
    private int subCorridorNum;
    private boolean movement;
    private final int powerThreshold = 10;

    public SubCorridor(int subCorridorNum) {
        light = new Light(POWER_PER_LIGHT, OFF);
        ac = new AC(POWER_PER_AC, ON);
        this.subCorridorNum = subCorridorNum;
    }

    public AC getAc() {
        return ac;
    }

    public int getSubCorridorNum() {
        return subCorridorNum;
    }

    public void getStatus(){
        System.out.print("Light 1 : " + light.getState() + " AC : " + ac.getState());
    }

    public int getPowerConsumption(){
        return light.getPower() + ac.getPower();
    }

    public void setMovement(boolean state,long millis) {
        movement = state;
        if(movement == true) {
            light.setState(ON);
            ac.setState(ON);
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            movement = false;
            light.setState(OFF);
        }
        else
            light.setState(OFF);
    }

    public boolean isMovement() {
        return movement;
    }

    public int getPowerThreshold() {
        return powerThreshold;
    }
}
