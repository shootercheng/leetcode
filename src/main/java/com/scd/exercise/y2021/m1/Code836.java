package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class Code836 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (!checkRec(rec1) || !checkRec(rec2)) {
            return false;
        }
        boolean isOutLeft = rec1[2] <= rec2[0];
        boolean isOutRight = rec1[0] >= rec2[2];
        boolean isOutTop = rec1[1] >= rec2[3];
        boolean isOutBottom = rec1[3] <= rec2[1];
        if (isOutLeft || isOutRight || isOutTop || isOutBottom) {
            return false;
        }
        return true;
    }

    private boolean checkRec(int[] rec) {
        if (rec[0] >= rec[2]) {
            return false;
        }
        if (rec[1] >= rec[3]) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] rec1 = {0,0,2,2};
        int[] rec2 = {1,1,3,3};
        Code836 code836 = new Code836();
        System.out.println(code836.isRectangleOverlap(rec1, rec2));
    }
}
