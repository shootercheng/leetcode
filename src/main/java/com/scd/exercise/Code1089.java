package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code1089 {

    public void duplicateZeros(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (i == 0) {
                list.add(0);
                list.add(0);
            } else {
                list.add(i);
            }
        }
        int alen = arr.length;
        for (int i = 0; i < alen; i++) {
            arr[i] = list.get(i);
        }
    }
}
