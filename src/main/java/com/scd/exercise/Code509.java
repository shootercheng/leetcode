package com.scd.exercise;

/**
 * @author James
 */
public class Code509 {

    public int fib(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        return fib(n - 1) * fib(n - 2);
//        f(0) = 0;
//        f(1) = 1;
//        f(2) = f(1) + f(0);
        int[] records = new int[n+1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        records[0] = 0;
        records[1] = 1;
        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                records[i] = records[i-1] + records[i-2];
            }
        }
        return records[n];
    }

    public static void main(String[] args) {
        Code509 code509 = new Code509();
        int result = code509.fib(45);
        System.out.println(result);
    }
}
