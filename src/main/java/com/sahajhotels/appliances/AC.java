package com.sahajhotels.appliances;

public class AC {
    private int power = 10;
    private String state;

    public AC() {
    }

    public AC(int power, String state) {
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
}
