package com.sahajhotels;

import com.sahajhotels.structures.Floor;
import com.sahajhotels.structures.Hotel;
import com.sahajhotels.utils.PowerConsumptionMonitor;
import com.sahajhotels.utils.Sensors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class HotelManagementApp {

    public static void main(String[] args) {

        SpringApplication.run(HotelManagementApp.class,args);

        Scanner s = new Scanner(System.in);

        final Hotel hotel1 = getHotel(s);

        final List<Floor> allFloors = hotel1.getFloors();

        printPowerConsumed(allFloors);

        PowerConsumptionMonitor.monitorPowerConsumption(allFloors);

        System.out.println("Inputs from Sensors:");
        int j = 0;

        Sensors.inputsFromSensors(s, hotel1, allFloors, j);
    }

    public static Hotel getHotel(Object obj) {

        if (obj instanceof Scanner) {
            Scanner s = (Scanner)obj;

            System.out.print("Number of floors: ");
            int floors = s.nextInt();

            System.out.print("Main corridors per floor: ");
            int mainCorridors = s.nextInt();

            System.out.print("Sub corridors per floor: ");
            int subCorridors = s.nextInt();

            return new Hotel(floors, mainCorridors, subCorridors);
        }
        else if(obj instanceof int[]){
            int[] vals = (int[])obj;
            return new Hotel(vals[0], vals[1], vals[2]);
        }
        else
            throw new ClassCastException();
    }

    public static void printPowerConsumed(List<Floor> allFloors) {
        for (Floor floor : allFloors) {
            System.out.println("Max power consumption allowed in Floor " +
                    floor.getFloorNum() + ": " + floor.getPowerThreshold());
        }
    }
}
