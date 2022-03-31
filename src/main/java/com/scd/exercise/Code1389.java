package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1389 {

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (list.size() > index[i]) {
                list.add(index[i], nums[i]);
            } else {
                list.add(nums[i]);
            }
        }
        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};
        Code1389 code1389 = new Code1389();
        int[] result = code1389.createTargetArray(nums, index);
        System.out.println(result);
    }
}
