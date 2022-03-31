package com.scd.exercise;

/**
 * @author James
 */
public class Code374 {
    private static int num = 6;

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            // 此写法可能导致溢出
//            int mid = left + (left + right) / 2;
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == -1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    private int guess(int mid) {
        if (mid == 6) {
            return 0;
        } else if (mid < 6) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Code374 code374 = new Code374();
        System.out.println(code374.guessNumber(10));
    }
}
