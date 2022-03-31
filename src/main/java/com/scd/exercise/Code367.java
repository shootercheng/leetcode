package com.scd.exercise;

/**
 * @author James
 */
public class Code367 {

    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid < 0) {
                right = left;
                left = 1;
                continue;
            }
            int cal = subNumVal(mid, num);
            if (cal == 0) {
                return true;
            } else if (cal > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public int subNumVal(int input, int num) {
        int multi = input * input;
        if (multi < 0) {
            return 1;
        }
        return multi - num;
    }

    public static void main(String[] args) {
        Code367 code367 = new Code367();
        System.out.println(code367.isPerfectSquare(2147395600));
    }
}
