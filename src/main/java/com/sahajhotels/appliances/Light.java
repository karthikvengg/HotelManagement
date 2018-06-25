package com.sahajhotels.appliances;

public class Light {
    private int power = 5;
    private String state;

    public Light() {
    }

    public Light(int power, String state) {
        this.power = power;
        this.state = state;
    }

    public int getPower() {
        if(state.equals("ON"))
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
