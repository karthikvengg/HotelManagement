package com.sahajhotels.utils;

import com.sahajhotels.HotelManagementApp;
import com.sahajhotels.structures.Floor;
import com.sahajhotels.structures.Hotel;
import com.sahajhotels.structures.SubCorridor;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class TestSensors {
    public static final String REGEX = ":";
    private static HotelManagementApp app;
    private static Sensors sensors;
    private static Hotel hotel;
    private static List<Floor> allFloors;

    @BeforeClass
    public static void intitializer() {
        app = new HotelManagementApp();
        sensors = new Sensors();

        int[] arr = {2, 1, 2};
        hotel = app.getHotel(arr);
        allFloors = hotel.getFloors();
    }

    @Test
    public void testPrintCurrentStatus() {
        sensors.printCurrentStatus(allFloors);
    }

    @Test
    public void testPrintAvailableOptions() {
        sensors.printAvailableOptions();
    }

    @Test
    public void testPrintPowerConsumedPerFloor() {
        sensors.printPowerConsumedPerFloor(allFloors);
    }

    @Test
    public void testChangeStateToMovementTest1() {

        sensors.changeStateToMovement(hotel, allFloors, "1:1:true");
        String[] vars = "1:1:true".split(REGEX);
        SubCorridor sc;
        sc = hotel.getFloor(Integer.parseInt(vars[0])).
                getSubCorridor(Integer.parseInt(vars[1]));
        boolean isMovement = sc.isMovement();
        assertTrue(isMovement);
    }

    @Test
    public void testChangeStateToMovementTest2() {

        sensors.changeStateToMovement(hotel, allFloors, "1:1:false");
        String[] vars = "1:1:true".split(REGEX);
        SubCorridor sc;
        sc = hotel.getFloor(Integer.parseInt(vars[0])).
                getSubCorridor(Integer.parseInt(vars[1]));
        boolean isMovement = sc.isMovement();
        assertFalse(isMovement);
    }
}
