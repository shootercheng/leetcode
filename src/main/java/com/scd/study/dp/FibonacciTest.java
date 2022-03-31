package com.scd.study.dp;

/**
 * n = 0,   f(0) = 0;
 * n = 1,   f(1) = 1;
 * f(n) = f(n-1) + f(n-2);
 * @author James
 */
public class FibonacciTest {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     *  备忘录法动态规划一般使用递归
     * @param n
     * @return
     */
    public int fibDp(int n) {
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = -1;
        }
        fibMemo(n, memo);
        return memo[n];
    }

    public int fibMemo(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        } else {
            memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
            return memo[n];
        }
    }

    public int fibDp2(int n) {
        if (n <= 1) {
            return n;
        }
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        FibonacciTest fibonacciTest = new FibonacciTest();
        System.out.println(fibonacciTest.fib(4));
        System.out.println(fibonacciTest.fibDp(4));
        System.out.println(fibonacciTest.fibDp2(4));
    }
}
