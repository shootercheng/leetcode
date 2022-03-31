package com.scd.contest.week250;

/**
 * @author James
 */
public class Code5814 {

    public int addRungs(int[] rungs, int dist) {
        int lenr = rungs.length;
        int start = 0;
        int count = 0;
        for (int i = 0; i < lenr; i++) {
            int next = rungs[i];
            if (next - start > dist) {
                int temp = start + dist;
                while (temp < next) {
                    temp = temp + dist;
                    count++;
                }
            }
            start = next;
        }
        return count;
    }

    public static void main(String[] args) {
        Code5814 code5814 = new Code5814();
        code5814.addRungs(new int[]{3}, 1);
    }
}
