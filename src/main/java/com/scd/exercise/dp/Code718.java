package com.scd.exercise.dp;

/**
 * @author James
 */
public class Code718 {

    public int findLength(int[] A, int[] B) {
        int lena = A.length;
        int lenb = B.length;
        if (lena == 0 || lenb == 0) {
            return 0;
        }
        int[][] record = new int[lena+1][lenb+1];
        int max = 0;
        for (int i = 1; i < lena+1; i++) {
            for (int j = 1; j < lenb+1; j++) {
                if (A[i-1] == B[j -1]) {
                    record[i][j] = record[i-1][j-1] + 1;
                    if (record[i][j] > max) {
                        max = record[i][j];
                    }
                } else {
                    record[i][j] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        Code718 code718 = new Code718();
        System.out.println(code718.findLength(A, B));
    }
}
