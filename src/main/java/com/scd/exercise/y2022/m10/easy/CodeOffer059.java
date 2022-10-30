package com.scd.exercise.y2022.m10.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据流的第K大数值
 */
public class CodeOffer059 {
    class KthLargest {
        private List<Integer> numList;

        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            numList = new ArrayList<>(nums.length);
            for (int num : nums) {
                numList.add(num);
            }
            numList = numList.stream().sorted().collect(Collectors.toList());
        }

        public int add(int val) {
            return 0;
        }
    }
}
