package com.scd.contest.week241;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author James
 */
public class Code5761 {

    static class FindSumPairs {
        private int[] nums1;

        private int[] nums2;


        private Map<Integer, List<Integer>> numIndexMap = new HashMap<>();

        public FindSumPairs(int[] nums1, int[] nums2) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            int lens2 = nums2.length;
            for (int i = 0; i < lens2; i++) {
                List<Integer> indexList = numIndexMap.computeIfAbsent(nums2[i], k -> new ArrayList<>());
                indexList.add(i);
            }
        }

        public void add(int index, int val) {
            int origin = nums2[index];
            List<Integer> indexList = numIndexMap.get(origin);
            indexList.remove(Integer.valueOf(index));
            nums2[index] = nums2[index] + val;
            List<Integer> targetIndexList = numIndexMap.computeIfAbsent(nums2[index], k -> new ArrayList<>());
            targetIndexList.add(index);
        }

        public int count(int tot) {
            int count = 0;
            for(int num : nums1) {
                int otherNum = tot - num;
                List<Integer> indexList = numIndexMap.get(otherNum);
                if (indexList != null) {
                    count = count + indexList.size();
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});
        findSumPairs.count(7);  // 返回 8 ; 下标对 (2,2), (3,2), (4,2), (2,4), (3,4), (4,4) 满足 2 + 5 = 7 ，下标对 (5,1), (5,5) 满足 3 + 4 = 7
        findSumPairs.add(3, 2); // 此时 nums2 = [1,4,5,4,5,4]
        findSumPairs.count(8);  // 返回 2 ；下标对 (5,2), (5,4) 满足 3 + 5 = 8
        findSumPairs.count(4);  // 返回 1 ；下标对 (5,0) 满足 3 + 1 = 4
        findSumPairs.add(0, 1); // 此时 nums2 = [2,4,5,4,5,4]
        findSumPairs.add(1, 1); // 此时 nums2 = [2,5,5,4,5,4]
        findSumPairs.count(7);  // 返回 11 ；下标对 (2,1), (2,2), (2,4), (3,1), (3,2), (3,4), (4,1), (4,2), (4,4) 满足 2 + 5 = 7 ，下标对 (5,3), (5,5) 满足 3 + 4 = 7
    }
}
