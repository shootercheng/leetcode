package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code1534 {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int lena = arr.length;
        int count = 0;
        for (int i = 0; i < lena; i++) {
            for (int j = i+1; j < lena; j++) {
                for (int k = j+1; k < lena; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1,1,9,7};
        Code1534 code1534 = new Code1534();
        System.out.println(code1534.countGoodTriplets(nums, 1,1,1));
    }
}
