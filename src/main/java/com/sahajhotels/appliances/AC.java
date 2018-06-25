package com.sahajhotels.appliances;

public class AC extends ApplianceOperations {

    private static final int POWER = 10;

    public AC() {
        this.setPower(POWER);
    }

    public AC(int power, String state) {
        this.setState(state);
        this.setPower(power);
    }
}
