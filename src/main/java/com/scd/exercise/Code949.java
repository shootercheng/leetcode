package com.scd.exercise;

/**
 * @author James
 */
public class Code949 {

    public String largestTimeFromDigits(int[] A) {
        int one = -1;
        int two = -1;
        int three = -1;
        int four = -1;
        int alen = A.length;
        boolean[] used = new boolean[alen];
        int oneIndex = -1;
        for (int i = 0; i < alen; i++) {
            if (A[i] <= 2 && A[i] > one) {
                one = A[i];
                oneIndex = i;
            }
        }
        if (one == -1) {
            return "";
        }
        used[oneIndex] = true;
        int twoIndex = -1;
        for (int i = 0; i < alen; i++) {
            if (!used[i]) {
                if (one <= 1) {
                    if (A[i] <= 9 && A[i] > two) {
                        two = A[i];
                        twoIndex = i;
                    }
                } else {
                    if (A[i] <= 3 && A[i] > two) {
                        two = A[i];
                        twoIndex = i;
                    }
                }
            }
        }
        if (two == -1) {
            return "";
        }
        used[twoIndex] = true;
        int threeIndex = -1;
        for (int i = 0; i < alen; i++) {
            if (!used[i] && A[i] <= 5 && A[i] > three) {
                three = A[i];
                threeIndex = i;
            }
        }
        if (three == -1) {
            return "";
        }
        used[threeIndex] = true;
        for (int i = 0; i < alen; i++) {
            if (!used[i]) {
                four = A[i];
            }
        }
        StringBuilder stringBuilder = new StringBuilder().append(one)
                .append(two).append(":").append(three).append(four);
        return stringBuilder.toString();
    }

    private int findNextMax(int[] a, boolean[] used) {
        int alen = a.length;
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < alen; i++) {
            if (!used[i] && a[i] > max ) {
                max = a[i];
                maxIndex = i;
            }
        }
        used[maxIndex] = true;
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,6,6};
        Code949 code949 = new Code949();
        System.out.println(code949.largestTimeFromDigits(nums));
    }
}
