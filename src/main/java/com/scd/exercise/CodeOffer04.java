package com.scd.exercise;

/**
 * @author James
 */
public class CodeOffer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            int mid = midFind(matrix[i], target);
            if (mid != -1) {
                return true;
            }
        }
        return false;
    }

    public int midFind(int[] inputArr, int target) {
        int len = inputArr.length;
        if (len == 0) {
            return -1;
        }
        if (target > inputArr[len - 1]) {
            return -1;
        }
        if (target < inputArr[0]) {
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == inputArr[mid]) {
                return mid;
            } else if (target > inputArr[mid]) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CodeOffer04 codeOffer04 = new CodeOffer04();
        int[] inputArr = {1,2,3,4,5};
        int index = codeOffer04.midFind(inputArr, 2);
        System.out.println(index);
    }
}
