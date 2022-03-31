package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int lenm = matrix.length;
        int lenn = matrix[0].length;
        int left = 0;
        int right = lenm - 1;
        int arrayIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][lenn - 1]) {
                arrayIndex = mid;
            } else if (target > matrix[mid][lenn - 1]) {
                left = mid + 1;
            } else if (target < matrix[mid][0]) {
                right = mid - 1;
            }
        }
        if (arrayIndex != -1) {
            return binarySearch(matrix[arrayIndex], target);
        }
        return false;
    }

    private boolean binarySearch(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == mid) {
                return true;
            }
            if (target > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code74 code74 = new Code74();
        System.out.println(code74.binarySearch(new int[]{1,2,3,4,5}, 1));
        System.out.println(code74.binarySearch(new int[]{1,2,3,4,5}, 2));
        System.out.println(code74.binarySearch(new int[]{1,2,3,4,5}, 5));
    }
}
