package com.scd.exercise;

/**
 * @author James
 */
public class Code1281 {

    public int subtractProductAndSum(int n) {
        int j = 1;
        int h = 0;
        while (n != 0) {
            int mod = n % 10;
            n = n / 10;
            j = j * mod;
            h = h + mod;
        }
        return j - h;
    }

    public static void main(String[] args) {
        Code1281 code1281 = new Code1281();
        int result = code1281.subtractProductAndSum(234);
        System.out.println(result);
    }
}
