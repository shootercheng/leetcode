package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class CodeOffer21 {

    public int[] exchange(int[] nums) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        int[] result = new int[nums.length];
        for (int i : nums) {
            if (i % 2 == 0) {
                evenList.add(i);
            } else {
                oddList.add(i);
            }
        }
        int lenOdd = oddList.size();
        for (int i = 0; i < lenOdd; i++) {
            result[i] = oddList.get(i);
        }
        int lenEven = evenList.size();
        for (int i = 0; i < lenEven; i++) {
            result[lenOdd + i] = evenList.get(i);
        }
        return result;
    }
}
