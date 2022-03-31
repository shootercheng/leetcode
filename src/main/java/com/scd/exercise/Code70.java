package com.scd.exercise;

/**
 * @author James
 */
public class Code70 {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        } else {
            int[] records = new int[n+1];
            records[1] = 1;
            records[2] = 2;
            for (int i = 3; i <=n; i++) {
                records[i] = records[i - 2] + records[i - 1];
            }
            return records[n];
        }
    }

    public static void main(String[] args) {
        Code70 code70 = new Code70();
        System.out.println(code70.climbStairs(3));
    }
}
