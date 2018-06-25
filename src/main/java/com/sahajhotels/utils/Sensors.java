package com.sahajhotels.utils;

import com.sahajhotels.structures.Floor;
import com.sahajhotels.structures.Hotel;
import com.sahajhotels.structures.SubCorridor;

import java.util.List;
import java.util.Scanner;

public class Sensors {

    public static final int MILLIS = 2000;
    public static final String STATUS = "status";
    public static final String POWER = "power";
    public static final String CLOSE = "close";
    public static final int WAIT_TIME_TO_TURN_ON_LIGHTS = 60000;

    public static void inputsFromSensors(Scanner s, final Hotel hotel1, List<Floor> allFloors, int
            j) {
        while (true) {

            j++;
            System.out.print(j + ": ");

            String input = s.next();

            if (input.equals(STATUS)) {
                for (Floor floor : allFloors) {
                    System.out.println("Floor " + floor.getFloorNum());
                    floor.getStatus();
                }
            } else if (input.contains(":")) {
                final String[] vars = input.split(":");
                new Thread() {
                    @Override
                    public void run() {
                        SubCorridor sc;
                        sc = hotel1.getFloor(Integer.parseInt(vars[0])).
                                getSubCorridor(Integer.parseInt(vars[1]));
                        sc.setMovement(Boolean.parseBoolean(vars[2]), WAIT_TIME_TO_TURN_ON_LIGHTS);
                    }
                }.start();
                try {
                    Thread.sleep(MILLIS);  // Waiting for the other threads to manage the
                    // electricity consumption
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (Floor floor : allFloors) {
                    System.out.println("Floor " + floor.getFloorNum());
                    floor.getStatus();
                }
            } else if (input.equals(POWER)) {
                for (Floor floor : allFloors) {
                    System.out.println("Floor " + floor.getFloorNum() + ": " +
                            floor.getPowerConsumption());
                }
            } else if (input.equals(CLOSE)) {
                System.exit(0);
            } else {
                System.out.println("No such option. Please try again.");
                System.out.println("OPTIONS: status (current state) / power " +
                        "(Power consumption per floor) " +
                        "/ 1:2:true (Floor:subCorridor:movement)");
            }
            System.out.println();
        }
    }
}