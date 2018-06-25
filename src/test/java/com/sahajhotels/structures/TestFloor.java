package com.sahajhotels.structures;

import com.sahajhotels.HotelManagementApp;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestFloor {
    public static final String REGEX = ":";
    private static HotelManagementApp app;
    private static Floor floor;
    private static Hotel hotel;
    private static List<Floor> allFloors;

    @BeforeClass
    public static void intitializer() {
        app = new HotelManagementApp();
        int[] arr = {2, 1, 2};
        hotel = app.getHotel(arr);
        allFloors = hotel.getFloors();
        floor = allFloors.get(0);
    }

    @Test
    public void testGetStatus(){
        floor.getStatus();
    }

    @Test
    public void testGetPowerConsumption(){
        int power = floor.getPowerConsumption();
        assertEquals(35,power);
    }

    @Test
    public void testGetSubCorridor(){
        SubCorridor sc = floor.getSubCorridor(1);
        assertTrue(sc instanceof SubCorridor);
    }

    @Test
    public void testGetPowerThreshold(){
        int threshold = floor.getPowerThreshold();
        assertEquals(35,threshold);
    }


}
