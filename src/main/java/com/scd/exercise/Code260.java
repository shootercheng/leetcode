package com.scd.exercise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author James
 */
public class Code260 {

    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                set.remove(num);
            }
        }
        int[] result = new int[set.size()];
        int i = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            result[i++] = iterator.next();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        Code260 code260 = new Code260();
        code260.singleNumber(nums);
    }
}
