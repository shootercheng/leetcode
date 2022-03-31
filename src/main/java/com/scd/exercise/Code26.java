package com.scd.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code26 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        int sum = 0;
        int removeNum = 0;
        int i = 0;
        while ((sum + removeNum) < len) {
            Integer value = map.get(nums[i]);
            if (value == null) {
                map.put(nums[i], 1);
                sum++;
                i++;
            } else {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                removeNum++;
                nums[len - 1] = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Code26 code26 = new Code26();
        int[] nums = new int[]{1,2,2,2};
        code26.removeDuplicates(nums);
        System.out.println(nums);
    }
}
