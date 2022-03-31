package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class Code1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int lenq = queries.length;
        int[] result = new int[lenq];
        for (int i = 0; i < lenq; i++) {
            int xor = 0;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                xor = xor ^ arr[j];
            }
            result[i] = xor;
        }
        return result;
    }

    public static void main(String[] args) {
        Code1310 code1310 = new Code1310();
        int[][] queries = new int[][]{
                {0,1},
                {1,2},
                {0,3},
                {3,3}
        };
        System.out.println(code1310.xorQueries(new int[]{1,3,4,8}, queries));
    }
}
