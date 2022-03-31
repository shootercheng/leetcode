package com.scd.exercise;

import java.util.Arrays;

/**
 * @author James
 */
public class Code645 {

    public int[] findErrorNums(int[] nums) {
        int nlen = nums.length;
        int[] result = new int[2];
        boolean[] finds = new boolean[nlen];
        for (int i = 0; i < nlen; i++) {
            int bIndex = nums[i] - 1;
            if (!finds[bIndex]) {
                finds[bIndex] = true;
            } else {
                result[0] = nums[i];
            }
        }
        for (int i = 0; i < nlen; i++) {
            if (!finds[i]) {
                result[1] = i+1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,3,2,2,7,6,4,8,9};
        Code645 code645 = new Code645();
        int[] res = code645.findErrorNums(nums);
        System.out.println(res);
    }
}
