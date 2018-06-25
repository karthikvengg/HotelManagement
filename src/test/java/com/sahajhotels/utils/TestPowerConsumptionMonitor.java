package com.sahajhotels.utils;

import com.sahajhotels.HotelManagementApp;
import com.sahajhotels.structures.Floor;
import com.sahajhotels.structures.Hotel;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class TestPowerConsumptionMonitor {
    private static HotelManagementApp app;
    private static PowerConsumptionMonitor pcm;
    private static Hotel hotel;
    private static List<Floor> allFloors;

    @BeforeClass
    public static void intitializer() {
        app = new HotelManagementApp();
        pcm = new PowerConsumptionMonitor();
        int[] arr = {2, 1, 2};
        hotel = app.getHotel(arr);
        allFloors = hotel.getFloors();
    }


    @Test
    public void testMonitorPowerConsumption(){
        pcm.monitorPowerConsumption(allFloors);
    }

    @Test
    public void testTurnOnAC(){
        pcm.turnOnAC(allFloors.get(0));
        pcm.turnOffAC(allFloors.get(0));
    }

    @Test
    public void testTurnOffAC(){
        pcm.turnOffAC(allFloors.get(0));
    }
}
