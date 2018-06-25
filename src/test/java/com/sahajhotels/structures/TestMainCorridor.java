package com.sahajhotels.structures;

import com.sahajhotels.appliances.AC;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestMainCorridor {

    private static MainCorridor mainCorridor;

    @BeforeClass
    public static void initialize(){
        mainCorridor = new MainCorridor(1);
    }

    @Test
    public void testGetAc(){
        AC ac = mainCorridor.getAc();
        assertTrue(ac instanceof AC);
    }

    @Test
    public void testGetMainCorridorNum(){
        assertEquals(1,mainCorridor.getMainCorridorNum());
    }

    @Test
    public void testGetPowerConsumption(){
        assertEquals(15,mainCorridor.getPowerConsumption());
    }

    @Test
    public void testGetPowerThreshold(){
        assertEquals(15,mainCorridor.getPowerThreshold());
    }

    @Test
    public void testIsMovement(){
        boolean result = mainCorridor.isMovement();
    }

    @Test
    public void testGetStatus(){
        mainCorridor.getStatus();
    }

}
