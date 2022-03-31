package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class Code492 {

    public int[] constructRectangle(int area) {
        int edge = (int) Math.sqrt(area);
        int[] result = new int[2];
        for (int i = edge; i <= area; i++) {
            if (area % i == 0) {
                int other = area / i;
                if (i >= other) {
                    result[0] = i;
                    result[1] = other;
                } else {
                    result[0] = other;
                    result[1] = i;
                }
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int edge = (int) Math.sqrt(5);
        System.out.println(edge);
        Code492 code492 = new Code492();
        System.out.println(code492.constructRectangle(4));
    }
}
