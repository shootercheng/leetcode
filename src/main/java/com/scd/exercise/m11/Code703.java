package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code703 {

    static class KthLargest {
        private List<Integer> list = new ArrayList<>();

        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int n : nums) {
                list.add(n);
            }
            list = list.stream().sorted().collect(Collectors.toList());
        }

        public int add(int val) {
            int size = list.size();
            boolean isInserted = false;
            for (int i = 0; i < size; i++) {
                if (val < list.get(i)) {
                    list.add(i, val);
                    isInserted = true;
                    break;
                }
            }
            if (!isInserted) {
                list.add(val);
            }
            return list.remove(k - 1);
//            list.remove(0);
//            return result;
        }
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
