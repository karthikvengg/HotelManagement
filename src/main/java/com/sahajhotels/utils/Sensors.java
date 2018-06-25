package com.sahajhotels.utils;

import com.sahajhotels.structures.Floor;
import com.sahajhotels.structures.Hotel;
import com.sahajhotels.structures.SubCorridor;

import java.util.List;
import java.util.Scanner;

public class Sensors {

    private static final int MILLIS = 2000;
    private static final String STATUS = "status";
    private static final String POWER = "power";
    private static final String CLOSE = "close";
    private static final int WAIT_TIME_TO_TURN_ON_LIGHTS = 60000;
    private static final String REGEX = ":";

    public static void inputsFromSensors(Scanner s, final Hotel hotel1, List<Floor> allFloors, int
            j) {
        while (true) {

            j++;
            System.out.print(j + ": ");

            String input = s.next();

            if (input.equals(STATUS)) {
                printCurrentStatus(allFloors);
            } else if (input.contains(REGEX)) {
                changeStateToMovement(hotel1, allFloors, input);
            } else if (input.equals(POWER)) {
                printPowerConsumedPerFloor(allFloors);
            } else if (input.equals(CLOSE)) {
                System.exit(0);
            } else {
                printAvailableOptions();
            }
            System.out.println();
        }
    }

    private static void printAvailableOptions() {
        System.out.println("No such option. Please try again.");
        System.out.println("OPTIONS: status (current state) / power " +
                "(Power consumption per floor) " +
                "/ 1:2:true (Floor:subCorridor:movement)");
    }

    private static void printPowerConsumedPerFloor(List<Floor> allFloors) {
        for (Floor floor : allFloors) {
            System.out.println("Floor " + floor.getFloorNum() + ": " +
                    floor.getPowerConsumption());
        }
    }

    private static void changeStateToMovement(final Hotel hotel1, List<Floor> allFloors, String input) {
        final String[] vars = input.split(REGEX);
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
        printCurrentStatus(allFloors);
    }

    private static void printCurrentStatus(List<Floor> allFloors) {
        for (Floor floor : allFloors) {
            System.out.println("Floor " + floor.getFloorNum());
            floor.getStatus();
        }
    }
}