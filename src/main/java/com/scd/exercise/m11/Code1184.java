package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start < destination) {
            return getMinDistance(distance, start, destination);
        } else {
            return getMinDistance(distance, destination, start);
        }
    }

    private int getMinDistance(int[] distance, int start, int destination) {
        int dis = 0;
        for (int i = start; i < destination; i++) {
            dis = dis + distance[i];
        }
        int reverseDis = 0;
        for (int i = destination; i < distance.length; i++) {
            reverseDis = reverseDis + distance[i];
        }
        for (int i = 0; i < start; i++) {
            reverseDis = reverseDis + distance[i];
        }
        return Math.min(dis, reverseDis);
    }
}
