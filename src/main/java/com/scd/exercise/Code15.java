package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code15 {

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Set<String> hashSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0 && i != j && j != k && i != k) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        StringBuilder stringBuilder = new StringBuilder();
                        list = list.stream().sorted().collect(Collectors.toList());
                        list.forEach(stringBuilder::append);
                        String orderNumStr = stringBuilder.toString();
                        if (!hashSet.contains(orderNumStr)) {
                            hashSet.add(orderNumStr);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Code15 code15 = new Code15();
        List<List<Integer>> result = code15.threeSum(nums);
        System.out.println(result);
    }
}
