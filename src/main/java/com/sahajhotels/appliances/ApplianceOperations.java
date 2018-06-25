package com.sahajhotels.appliances;

abstract class ApplianceOperations implements Appliance{

    private int power;
    private String state = ON;

    public int getPower() {
        if(state.equals(ON))
            return power;
        else
            return 0;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
