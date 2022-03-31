package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code832 {

    public int[][] flipAndInvertImage(int[][] A) {
        int lena = A.length;
        for (int i = 0; i < lena; i++) {
            processRowArr(A[i]);
        }
        return A;
    }

    private void processRowArr(int[] input) {
        int left = 0;
        int leni = input.length;
        int right = leni - 1;
        while (left < right) {
            int temp = input[left];
            input[left] = input[right];
            input[right] = temp;
            input[left] = 1 - input[left];
            input[right] = 1 - input[right];
            left++;
            right--;
        }
        if (leni % 2 != 0) {
            int mid = leni / 2;
            input[mid] = 1 - input[mid];
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };
        Code832 code832 = new Code832();
        code832.flipAndInvertImage(array);
        System.out.println(array);
    }
}
