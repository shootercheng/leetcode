package com.scd.exercise.m11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        List<Integer> list = Arrays.stream(nums).distinct().boxed()
                .sorted().collect(Collectors.toList());
        int max = 0;
        int lenn = list.size();
        int temp = 1;
        for (int i = 0; i < lenn - 1; i++) {
            if (list.get(i) + 1 == list.get(i+1)) {
                temp++;
            } else {
                if (temp > max ) {
                    max = temp;
                }
                temp = 1;
            }
        }
        if (temp > max) {
            max = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        Code128 code128 = new Code128();
        System.out.println(code128.longestConsecutive(nums));
        System.out.println(code128.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(code128.longestConsecutive(new int[]{1,2,0,1}));
    }
}
