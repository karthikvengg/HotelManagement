package com.sahajhotels.structures;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Floor {

    private int floorNum;
    private List<MainCorridor> c;
    private List<SubCorridor> sc;

    public Floor() {
        c = new ArrayList<MainCorridor>();
        sc = new ArrayList<SubCorridor>();
        c.add(new MainCorridor());
        sc.add(new SubCorridor());
    }

    public Floor(int mainCorridors, int subCorridors, int floorNum) {

        this.floorNum = floorNum;
        c = new ArrayList<MainCorridor>();
        sc = new ArrayList<SubCorridor>();

        for (int i = 0; i < mainCorridors; i++)
            c.add(new MainCorridor(i + 1));
        for (int i = 0; i < subCorridors; i++)
            sc.add(new SubCorridor(i + 1));
    }

    public void getStatus() {
        for (MainCorridor mc : c) {
            System.out.print("Main corridor " + mc.getMainCorridorNum() + " ");
            mc.getStatus();
            System.out.println();
        }
        for (SubCorridor sc : sc) {
            System.out.print("Sub corridor " + sc.getSubCorridorNum() + " ");
            sc.getStatus();
            System.out.println();
        }
    }

    public int getPowerConsumption() {
        int power = 0;
        for (MainCorridor c : c) {
            power = power + c.getPowerConsumption();
        }
        for (SubCorridor sc : sc) {
            power = power + sc.getPowerConsumption();
        }
        return power;
    }

    public SubCorridor getSubCorridor(int subCorridorNumber) {
        return sc.get(subCorridorNumber - 1);
    }

    public int getPowerThreshold() {
        int threshold = 0;

        for (MainCorridor c : c) {
            threshold += c.getPowerThreshold();
        }
        for (SubCorridor sc : sc) {
            threshold += sc.getPowerThreshold();
        }

        return threshold;
    }
}
