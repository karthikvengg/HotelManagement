package com.sahajhotels.structures;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Hotel {
    private List<Floor> floors;

    public Hotel() {
        this.floors = new ArrayList<Floor>();
        floors.add(new Floor());
    }

    public Hotel(int floors, int mainCorridors, int subCorridors) {

        this.floors = new ArrayList<Floor>();

        for(int i=0;i<floors;i++){
            this.floors.add(new Floor(mainCorridors,subCorridors,i+1));
        }
    }

    public Floor getFloor(int floorNumber) {
        return floors.get(floorNumber-1);
    }

}
