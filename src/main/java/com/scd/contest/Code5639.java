package com.scd.contest;

/**
 * @author James
 */
public class Code5639 {

    public int minimumTimeRequired(int[] jobs, int k) {
        long sum = 0;
        for (int job : jobs) {
            sum = sum + job;
        }
        long mod = sum % k;
        int result = (int) sum / k;
        if (mod != 0) {
            result = result + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] jobs = {1,2,4,7,8};
        Code5639 code5639 = new Code5639();
        System.out.println(code5639.minimumTimeRequired(jobs, 2));
    }
}
