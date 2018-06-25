package com.sahajhotels.appliances;

public class Light extends ApplianceOperations {

    private static final int POWER = 5;

    public Light() {
        this.setPower(POWER);
    }

    public Light(int power, String state) {
        this.setState(state);
        this.setPower(power);
    }

}
