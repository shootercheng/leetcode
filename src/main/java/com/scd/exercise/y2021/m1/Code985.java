package com.scd.exercise.y2021.m1;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author James
 */
public class Code985 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[A.length];
        int lenq = queries.length;
        for (int i = 0; i < lenq; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            A[index] = A[index] + val;
            result[i] = calSum(A);
        }
        return result;
    }

    private int calSum(int[] A) {
        int sum = 0;
        int lena = A.length;
//        int[] b = new int[lena];
//        System.arraycopy(A, 0, b, 0, lena);
//        Arrays.sort(b);
        for (int num : A) {
            if (num % 2 == 0) {
                sum = sum + num;
            }
        }
        return sum;
    }

    public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
        int[] result = new int[A.length];
        int sum = 0;
        for (int num : A) {
            if (num % 2 == 0) {
                sum = sum + num;
            }
        }
        int rIndex = 0;
        for (int[] querie : queries) {
            int val = querie[0];
            int index = querie[1];
            int origin = A[index];
            if (origin % 2 == 0) {
                sum = sum - origin;
            }
            int addVal = origin + val;
            if (addVal % 2 == 0) {
                sum = sum + addVal;
            }
            A[index] = addVal;
            result[rIndex++] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        Code985 code985 = new Code985();
        System.out.println(Arrays.toString(code985.sumEvenAfterQueries2(A, queries)));
    }
}
