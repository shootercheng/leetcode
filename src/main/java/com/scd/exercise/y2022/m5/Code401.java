package com.scd.exercise.y2022.m5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code401 {

    public List<String> readBinaryWatch(int turnedOn) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        for (int i = 1; i < 60; i++) {
            System.out.println(i + "=============" + Integer.bitCount(i));
        }
    }
}
