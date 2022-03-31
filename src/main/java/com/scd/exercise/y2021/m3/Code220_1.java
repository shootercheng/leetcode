package com.scd.exercise.y2021.m3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code220_1 {

    class NumIndex {
        private int index;

        private long num;

        public NumIndex(int index, long num) {
            this.index = index;
            this.num = num;
        }

        public int getIndex() {
            return index;
        }

        public long getNum() {
            return num;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        List<NumIndex> list = new ArrayList<>();
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            NumIndex numIndex = new NumIndex(i, nums[i]);
            list.add(numIndex);
        }
        List<NumIndex> sortNumList = list.stream().sorted(Comparator.comparingLong(NumIndex::getNum))
                .collect(Collectors.toList());
        for (int i = 0; i < lenn - 1; i++) {
            NumIndex start = sortNumList.get(i);
            NumIndex next = sortNumList.get(i+1);
            if (Math.abs(next.num - start.num) <= t && Math.abs(next.index - start.index) <= k) {
                return true;
            }
        }
        for (int i = 0; i < lenn - 1; i++) {
            for (int j = i+1; j < lenn; j++) {
                NumIndex numi = sortNumList.get(i);
                NumIndex numj = sortNumList.get(j);
                if (Math.abs(numj.num - numi.num) <= t && Math.abs(numj.index - numi.index) <= k) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Code220_1 code220_1 = new Code220_1();
        int[] nums = {-2147483648,2147483647};
        System.out.println(code220_1.containsNearbyAlmostDuplicate(nums, 1, 1));
    }
}
