package com.scd.exercise.y2022.m3;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.04. 幂集
 * @author James
 */
public class Code0804 {

    public List<List<Integer>> subsets(int[] nums) {
        int lenn = nums.length;
        int loop = (int) Math.pow(2, lenn);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < loop; i++) {
            String binary = Integer.toBinaryString(i);
            int index = lenn - 1;
            List<Integer> row = new ArrayList<>();
            for (int j = binary.length() - 1; j >= 0; j--) {
                char curChar = binary.charAt(j);
                if (curChar == '1') {
                    row.add(nums[index]);
                }
                index--;
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        Code0804 code0804 = new Code0804();
        code0804.subsets(new int[]{1,2,3});
    }
}
