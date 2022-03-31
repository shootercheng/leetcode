package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code941 {

    public boolean validMountainArray(int[] A) {
        int lena = A.length;
        int index = -1;
        for (int i = 0; i < lena - 1; i++) {
            if (A[i] > A[i+1]) {
                index = i;
                break;
            }
        }
        if (index == -1 || index == 0) {
            return false;
        } else {
            for (int i = 0; i <= index - 1; i++) {
                if (A[i] >= A[i+1]) {
                    return false;
                }
            }
            for (int i = index + 1; i < lena - 1; i++) {
                if (A[i] <= A[i+1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {14,82,89,84,79,70,70,68,67,66,63,60,58,54,44,43,32,28,26,25,22,15,13,12,10,8,7,5,4,3};
        Code941 code941 = new Code941();
        System.out.println(code941.validMountainArray(arr));
    }
}
