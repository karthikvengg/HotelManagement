package com.sahajhotels;

import com.sahajhotels.structures.Floor;
import com.sahajhotels.structures.Hotel;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class TestHotelManagementApp {
    private static HotelManagementApp app;

    @BeforeClass
    public static void intitializer(){
        app = new HotelManagementApp();
    }

    @Test
    public void testGetHotel(){
        int[] arr = {2,1,2};
        Hotel hotel = app.getHotel(arr);
        assertTrue(hotel instanceof Hotel);
    }

    @Test
    public void testPrintPowerConsumed(){
        int[] arr = {2,1,2};
        Hotel hotel = app.getHotel(arr);
        List<Floor> allFloors = hotel.getFloors();
        app.printPowerConsumed(allFloors);
    }
}
