package com.scd.exercise.y2022.m3;

/**
 * 2028. 找出缺失的观测数据
 * @author James
 */
public class Code2028 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int lenr = rolls.length;
        int sum = (lenr + n) * mean;
        for (int roll : rolls) {
            sum = sum - roll;
        }
        if (sum > n * 6 || sum < 0) {
            return new int[]{};
        }
        int average = sum / n;
        if (average == 0) {
            return new int[]{};
        }
        int mod = sum % n;
        int[] result = new int[n];
        int loop = n;
        int left = sum - average * (n - 1);
        if (mod != 0) {
            loop = n - 1;
            result[n - 1] = left;
        }
        for (int i = 0; i < loop; i++) {
            result[i] = average;
        }
        if (left > 6) {
            result[n - 1] = 6;
            int lsum = left - 6;
            int index = 0;
            while (lsum > 0 && index < n - 1) {
                int not6 = 6 - result[index];
                if (not6 > 0 && lsum >= not6) {
                    lsum = lsum - not6;
                    result[index] = 6;
                } else {
                    result[index] = result[index] + lsum;
                    lsum = 0;
                }
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Code2028 code2028 = new Code2028();
        code2028.missingRolls(new int[]{4,5,6,2,3,6,5,4,6,4,5,1,6,3,1,4,5,5,3,2,3,5,3,2,1,5,4,3,5,1,5}, 4, 40);
    }
}
