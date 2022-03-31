package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int lena = A.length;
        int sum = calSum(A, lena);
        if (sum % 3 != 0) {
            return false;
        }
        int part = sum / 3;
        int temp = 0;
        int count = 0;
        for (int i = 0; i < lena; i++) {
            temp = temp + A[i];
            if (temp == part) {
                temp = 0;
                count++;
            }
        }
        if (temp == 0 && count >= 3) {
            return true;
        }
        return false;
    }

    public int calSum(int[] arr, int len) {
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum = sum + arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] inputArr = {0,2,1,-6,6,-7,9,1,2,0,1};
//        int[] inputArr2 = {0,2,1,-6,6,7,9,-1,2,0,1};
//        int[] inputArr3 = {0,2,1,-6,6,-7,9,1,2,0,1};
        int[] inputArr4 = {10,-10,10,-10,10,-10,10,-10};
        Code1013 code1013 = new Code1013();
//        System.out.println(code1013.canThreePartsEqualSum(inputArr));
//        System.out.println(code1013.canThreePartsEqualSum(inputArr2));
//        System.out.println(code1013.canThreePartsEqualSum(inputArr3));
        System.out.println(code1013.canThreePartsEqualSum(inputArr4));
    }
}
