package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author James
 */
public class Code398 {

    class Solution {
        private Map<Integer, List<Integer>> numIndexListMap = new HashMap<>();

        public Solution(int[] nums) {
            int lenn = nums.length;
            for (int i = 0; i < lenn; i++) {
                List<Integer> indexList = numIndexListMap.computeIfAbsent(nums[i], k -> new ArrayList<>());
                indexList.add(i);
            }
        }

        public int pick(int target) {
            List<Integer> indexList = numIndexListMap.get(target);
            int size = indexList.size();
            if (size == 1) {
                return indexList.get(0);
            }
            Random random = new Random();
            return indexList.get(random.nextInt(size));
        }
    }

    public static void main(String[] args) {
        Code398 code398 = new Code398();
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            System.out.println(random.nextInt(5));
        }
    }
}
