package com.scd.exercise.y2021.m7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        int lenn = nums.length;
        List<Integer> list = new ArrayList<>();
        resultList.add(list);
        for (int i = 1; i <= lenn; i++) {
            combination(nums, 0, i, list, resultList);
        }
        return resultList;
    }

    public void combination(int[] nums, int startIndex, int endIndex, List<Integer> list, List<List<Integer>> resultList) {
        if (endIndex == 0) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        if (startIndex == nums.length) {
            return;
        }
        list.add(nums[startIndex]);
        combination(nums, startIndex + 1, endIndex - 1, list, resultList);
        list.remove(list.size() - 1);
        combination(nums, startIndex + 1, endIndex, list, resultList);
    }





    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Code78 code78 = new Code78();
        System.out.println(code78.subsets(nums));
        System.out.println(code78.subsets(new int[]{0}));
    }
}
