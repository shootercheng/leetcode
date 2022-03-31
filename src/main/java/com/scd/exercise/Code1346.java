package com.scd.exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code1346 {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> numSet = new HashSet<>(arr.length);
        for (int i : arr) {
            if (i == 0) {
                continue;
            }
            numSet.add(i);
        }
        for (int i : arr) {
            if (numSet.contains(2 * i)) {
                return true;
            }
        }
        return false;
    }
}
