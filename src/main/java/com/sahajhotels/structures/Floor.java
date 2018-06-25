package com.sahajhotels.structures;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private int floorNum;
    private List<MainCorridor> c;
    private List<SubCorridor> sc;

    public Floor() {
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

    public List<MainCorridor> getC() {
        return c;
    }

    public void setC(List<MainCorridor> c) {
        this.c = c;
    }

    public List<SubCorridor> getSC() {
        return sc;
    }

    public void setSc(List<SubCorridor> sc) {
        this.sc = sc;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void getStatus() {
        for (MainCorridor mc : c) {
            System.out.print("HotelManagementApp corridor " + mc.getMainCorridorNum() + " ");
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
