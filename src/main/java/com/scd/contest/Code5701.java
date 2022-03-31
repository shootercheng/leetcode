package com.scd.contest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code5701 {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        List<Character> diff1 = new ArrayList<>();
        List<Character> diff2 = new ArrayList<>();
        int count = 0;
        int lens = s1Arr.length;
        for (int i = 0; i < lens; i++) {
            if (s1Arr[i] != s2Arr[i]) {
                diff1.add(s1Arr[i]);
                diff2.add(s2Arr[i]);
                count++;
                if (count == 3) {
                    return false;
                }
            }
        }
        if (count == 0) {
            return true;
        } else if (count == 1) {
            if (diff1.get(0).equals(diff2.get(0))) {
                return true;
            }
        } else if (count == 2) {
            diff1 = diff1.stream().sorted().collect(Collectors.toList());
            diff2 = diff2.stream().sorted().collect(Collectors.toList());
            if (diff1.get(0).equals(diff2.get(0)) && diff1.get(1).equals(diff2.get(1))) {
                return true;
            }
        }
        return false;
    }
}
