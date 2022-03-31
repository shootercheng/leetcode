package com.scd.exercise.y2022.m3;

import com.scd.exercise.y2021.m3.Code220;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 2200. 找出数组中的所有 K 近邻下标
 * @author James
 */
public class Code2200 {

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> result = new HashSet<>();
        int lenn = nums.length;
        for (int i = 0; i < lenn; i++) {
            if (nums[i] == key) {
                for (int start = i; start >= i - k && start >= 0; start--) {
                    result.add(start);
                }
                for (int start = i; start <= i + k && start < lenn; start++) {
                    result.add(start);
                }
            }
        }
        return new ArrayList<>(result).stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Code2200 code2200 = new Code2200();
        code2200.findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9, 1);
    }
}
