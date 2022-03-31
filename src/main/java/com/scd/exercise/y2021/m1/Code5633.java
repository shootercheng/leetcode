package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class Code5633 {

    public int totalMoney(int n) {
        int weekNum = 1;
        int sum = 0;
        while (n > 0) {
            int end;
            int dis;
            if (n >= 7) {
                end = weekNum + 6;
                dis = 7;
            } else {
                end = weekNum + n - 1;
                dis = n;
            }
            int curSum = (weekNum + end) * dis / 2;
            sum = sum + curSum;
            weekNum++;
            n = n - 7;
        }
        return sum;
    }

    public static void main(String[] args) {
        Code5633 code5633 = new Code5633();
        int sum = code5633.totalMoney(10);
        System.out.println(sum);
    }
}
