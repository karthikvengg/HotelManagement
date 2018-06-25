package com.sahajhotels.appliances;

import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestAC {

    private static AC ac;

    @BeforeClass
    public static void initialize(){
        ac = new AC();
    }

    @Test
    public void testGetPowerWhenON(){
        ac.setState("ON");
        int power = ac.getPower();
        assertEquals(10,power);
    }

    @Test
    public void testGetPowerWhenOFF(){
        ac.setState("OFF");
        int power = ac.getPower();
        assertEquals(0,power);
    }

    @Test
    public void testGetStateWhenON(){
        ac.setState("ON");
        String state = ac.getState();
        assertEquals("ON",state);
    }

    @Test
    public void testGetStateWhenOFF(){
        ac.setState("OFF");
        String state = ac.getState();
        assertEquals("OFF",state);
    }

    @Test
    public void testSetState(){
        ac.setState("OFF");
        assertEquals("OFF",ac.getState());
        ac.setState("ON");
        assertEquals("ON",ac.getState());
    }
}
