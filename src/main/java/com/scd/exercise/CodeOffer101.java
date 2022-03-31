package com.scd.exercise;

/**
 * @author James
 */
public class CodeOffer101 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] records = new int[n+1];
        records[0] = 0;
        records[1] = 1;
        for (int i = 2; i <= n; i++) {
            records[i] = records[i-1] + records[i-2];
        }
        return records[n];
    }

    public static void main(String[] args) {
        CodeOffer101 codeOffer101 = new CodeOffer101();
        System.out.println(codeOffer101.fib(45));
    }
}
