package com.sahajhotels.appliances;

import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestLight {

    private static Light light;

    @BeforeClass
    public static void initialize(){
        light = new Light();
    }

    @Test
    public void testGetPowerWhenON(){
        light.setState("ON");
        int power = light.getPower();
        assertEquals(5,power);
    }

    @Test
    public void testGetPowerWhenOFF(){
        light.setState("OFF");
        int power = light.getPower();
        assertEquals(0,power);
    }

    @Test
    public void testGetStateWhenON(){
        light.setState("ON");
        String state = light.getState();
        assertEquals("ON",state);
    }

    @Test
    public void testGetStateWhenOFF(){
        light.setState("OFF");
        String state = light.getState();
        assertEquals("OFF",state);
    }

    @Test
    public void testSetState(){
        light.setState("OFF");
        assertEquals("OFF",light.getState());
        light.setState("ON");
        assertEquals("ON",light.getState());
    }
}
