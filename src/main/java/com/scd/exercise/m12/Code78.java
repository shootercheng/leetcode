package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        int lenn = nums.length;
        for (int i = 0; i <= lenn - 1; i++) {
            for (int j = i; j < lenn; j++) {
                List<Integer> oneList = new ArrayList<>();
                for (int k = i; k <= j; k++) {
                    oneList.add(nums[k]);
                }
                resultList.add(oneList);
            }
        }
        resultList.add(new ArrayList<>());
        return resultList;
    }

    public static void main(String[] args) {
        Code78 code78 = new Code78();
        System.out.println(code78.subsets(new int[]{1,2,3}));
    }
}
