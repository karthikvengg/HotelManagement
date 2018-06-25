package com.sahajhotels.structures;

import com.sahajhotels.appliances.AC;
import com.sahajhotels.appliances.Appliance;
import com.sahajhotels.appliances.Light;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubCorridor {

    private static final String OFF = "OFF";
    private static final String ON = "ON";
    private Appliance light;
    private Appliance ac;
    private int subCorridorNum;
    private boolean movement;

    public SubCorridor() {
        light = new Light();
        light.setState(OFF);
        ac = new AC();
    }

    public SubCorridor(int subCorridorNum) {
        light = new Light();
        light.setState(OFF);
        ac = new AC();
        this.subCorridorNum = subCorridorNum;
    }

    public void getStatus(){
        System.out.print("Light 1 : " + light.getState() + " AC : " + ac.getState());
    }

    public int getPowerConsumption(){
        return light.getPower() + ac.getPower();
    }

    public void setMovement(boolean state,long millis) {
        movement = state;
        if(movement) {
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

    public int getPowerThreshold() {
        int powerThreshold = 10;
        return powerThreshold;
    }

    public int getSubCorridorNum() {
        return subCorridorNum;
    }
}
