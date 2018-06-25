package com.sahajhotels.structures;

import com.sahajhotels.appliances.AC;
import com.sahajhotels.appliances.Light;

public class MainCorridor {
    private static final String ON = "ON";
    private static final int POWER_PER_LIGHT = 5;
    private static final int POWER_PER_AC = 10;
    private Light light;
    private AC ac;
    private int mainCorridorNum;
    private boolean movement = false;

    public MainCorridor(int mainCorridorNum) {
        light = new Light(POWER_PER_LIGHT, ON);
        ac = new AC(POWER_PER_AC,ON);
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
        int powerThreshold = 15;
        return powerThreshold;
    }

    public boolean isMovement() {
        return movement;
    }

    public static String getON() {
        return ON;
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public void setAc(AC ac) {
        this.ac = ac;
    }

    public void setMainCorridorNum(int mainCorridorNum) {
        this.mainCorridorNum = mainCorridorNum;
    }

    public void setMovement(boolean movement) {
        this.movement = movement;
    }
}
