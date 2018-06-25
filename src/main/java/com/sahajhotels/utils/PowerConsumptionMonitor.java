package com.sahajhotels.utils;

import com.sahajhotels.structures.Floor;
import com.sahajhotels.structures.MainCorridor;
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
                        if (power > threshold) {
                            turnOffAC(floor);
                        } else if (power < threshold) {
                            turnOnAC(floor);
                        }
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }

    public static void turnOnAC(Floor floor) {
        boolean flag = false;
        for (SubCorridor sc : floor.getSc()) {
            if (sc.getAc().getState().equals(OFF)) {
                sc.getAc().setState(ON);
                flag = true;
                break;
            }
        }
        if(flag) return;
        for (MainCorridor c : floor.getC()) {
            if (c.getAc().getState().equals(OFF)) {
                c.getAc().setState(ON);
                break;
            }
        }
    }


    public static void turnOffAC(Floor floor) {
        boolean flag = false;
        for (SubCorridor sc : floor.getSc()) {
            if (!sc.isMovement()) {
                sc.getAc().setState(OFF);
                flag = true;
                break;
            }
        }
        if(flag) return;
        for (MainCorridor c : floor.getC()) {
            if (!c.isMovement()) {
                c.getAc().setState(OFF);
                break;
            }
        }
    }
}
