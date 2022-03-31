package com.scd.exercise.m12;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        fullPermute(nums, 0,  nums.length, resultList);
        return resultList;
    }

    public void fullPermute(int[] nums, int startIndex, int len, List<List<Integer>> resultList) {
        if (startIndex == len - 1) {
            List<Integer> one = new ArrayList<>();
            for (int num : nums) {
                one.add(num);
            }
            resultList.add(one);
        } else {
            for (int i = startIndex; i < len; i++) {
                swapNum(nums, startIndex, i);
                fullPermute(nums, startIndex + 1, len, resultList);
                swapNum(nums, i, startIndex);
            }
        }
    }

    private void swapNum(int[] nums, int startIndex, int i) {
        int temp = nums[startIndex];
        nums[startIndex] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        Code46 code46 = new Code46();
        int[] nums = {1,2,3,4,5,6};
        code46.permute(nums);
    }
}
