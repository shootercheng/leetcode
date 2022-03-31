package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1287 {

    public int findSpecialInteger(int[] arr) {
        int lena = arr.length;
        if (lena == 0) {
            return 0;
        }
        int mod = lena % 4;
        int threshold = lena / 4;
        if (mod != 0) {
            threshold = threshold + 1;
        }
        int count = 1;
        int temp = arr[0];
        for (int i = 1; i < lena; i++) {
            if (arr[i] == temp) {
                count++;
                if (count > threshold) {
                    return temp;
                }
            } else {
                temp = arr[i];
                count = 1;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,6,6,6,6,7,10};
        Code1287 code1287 = new Code1287();
        System.out.println(code1287.findSpecialInteger(arr));
    }
}
