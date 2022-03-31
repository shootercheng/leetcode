package com.scd.exercise;

/**
 * @author James
 */
public class Code1299 {

    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        for (int i = 0; i < len - 1; i++) {
            int maxIndex = findMaxIndex(arr, i+1);
            result[i] = arr[maxIndex];
        }
        result[len - 1] = -1;
        return result;
    }

    public int findMaxIndex(int[] arr, int start) {
        int len = arr.length;
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Code1299 code1299 = new Code1299();
        int[] arr = {17,18,5,4,6,1};
        int[] result = code1299.replaceElements(arr);
        System.out.println(result);
    }
}
