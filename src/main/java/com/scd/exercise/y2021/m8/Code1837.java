package com.scd.exercise.y2021.m8;

/**
 * @author James
 */
public class Code1837 {

    public int sumBase(int n, int k) {
        int sum = 0;
        while (n > k) {
            int mod = n % k;
            sum = sum + mod;
            n = n / k;
        }
        sum = sum + n;
        return sum;
    }

    public static void main(String[] args) {
        Code1837 code1837 = new Code1837();
        System.out.println(code1837.sumBase(34, 6));
    }
}
