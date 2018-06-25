package com.sahajhotels.utils;

import com.sahajhotels.structures.MainCorridor;
import com.sahajhotels.structures.Floor;
import com.sahajhotels.structures.SubCorridor;

import java.util.List;

public class PowerConsumptionMonitor {

    private static final String OFF = "OFF";
    private static final String ON = "ON";

    public static void monitorPowerConsumption(final List<Floor> allFloors) {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    for (Floor floor : allFloors) {
                        int power = floor.getPowerConsumption();
                        int threshold = floor.getPowerThreshold();
                        // turn off when power consumption exceeds
                        turnOffAC(floor, power, threshold);
                        // turn on when power consumption is not exceeded
                        turnOnAC(floor, power, threshold);
                    }
                }
            }
        }.start();
    }

    private static void turnOnAC(Floor floor, int power, int threshold) {
        if (power < threshold - 5) {
            for (SubCorridor sc : floor.getSC()) {
                if (sc.getAc().getState().equals(ON)) {
                    sc.getAc().setState(ON);
                    break;
                }
            }
            for (MainCorridor c : floor.getC()) {
                if (c.getAc().getState().equals(OFF)) {
                    c.getAc().setState(ON);
                    break;
                }
            }
        }
    }

    private static void turnOffAC(Floor floor, int power, int threshold) {
        if (power > threshold) {
            for (SubCorridor sc : floor.getSC()) {
                if (!sc.isMovement()) {
                    sc.getAc().setState(OFF);
                    break;
                }
            }
            for (MainCorridor c : floor.getC()) {
                if (!c.isMovement()) {
                    c.getAc().setState(OFF);
                    break;
                }
            }
        }
    }
}