package com.scd.exercise.m10;

/**
 * @author James
 */
public class Code1588 {

    public int sumOddLengthSubarrays(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int step = 1; step <= len; step = step + 2) {
            for (int i = 0; i < len; i++) {
//                StringBuilder group = new StringBuilder("");
                int end = i + step;
                if (end > len) {
                    break;
                }
                for (int j = i; j < end; j++) {
//                    group.append(arr[j]).append(",");
                    sum = sum + arr[j];
                }
//                System.out.println(group);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Code1588 code1588 = new Code1588();
        int[] arr = {1,4,2,5,3};
        System.out.println(code1588.sumOddLengthSubarrays(arr));
        int[] arr1 = {1,2};
        System.out.println(code1588.sumOddLengthSubarrays(arr1));
    }
}
