package com.sahajhotels.appliances;

public interface Appliance {

    String ON = "ON";
    String OFF = "OFF";

    int getPower();

    String getState();

    void setState(String state);

    void setPower(int power);
}
