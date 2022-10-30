package com.scd.exercise.y2022.m4.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 398. 随机数索引
 * @author James
 */
public class Code398 {

    class Solution {
        private Map<Integer, List<Integer>> numIndexListMap;

        private Random random;

        public Solution(int[] nums) {
            numIndexListMap = new HashMap<>();
            random = new Random();
            int lenn = nums.length;
            for (int i = 0; i < lenn; i++) {
                List<Integer> indexList = numIndexListMap.computeIfAbsent(nums[i], k -> new ArrayList<>());
                indexList.add(i);
            }
        }

        public int pick(int target) {
            List<Integer> indexList = numIndexListMap.get(target);
            if (indexList == null) {
                return -1;
            }
            int index = random.nextInt(indexList.size() + 1);
            return indexList.get(index);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(2));
        }
    }

}
