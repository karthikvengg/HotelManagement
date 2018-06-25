package com.sahajhotels.structures;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Floor> floors;

    public Hotel(int floors,int mainCorridors,int subCorridors) {

        this.floors = new ArrayList<Floor>();

        for(int i=0;i<floors;i++){
            this.floors.add(new Floor(mainCorridors,subCorridors,i+1));
        }
    }

    public List<Floor> getAllFloors() {
        return floors;
    }

    public Floor getFloor(int floorNumber) {
        return floors.get(floorNumber-1);
    }

}
