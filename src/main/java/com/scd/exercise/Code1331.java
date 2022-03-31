package com.scd.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code1331 {

    public int[] arrayRankTransform(int[] arr) {
        int alen = arr.length;
        int[] temp = new int[alen];
        System.arraycopy(arr, 0, temp, 0, alen);
        Arrays.sort(temp);
        Map<Integer, Integer> orderMap = new HashMap<>();
        int order = 1;
        for (int i = 0; i < alen; i++) {
            if (!orderMap.containsKey(temp[i])) {
                orderMap.put(temp[i], order++);
            }
        }
        int[] result = new int[alen];
        for (int i = 0; i < alen; i++) {
            result[i] = orderMap.get(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {40,10,20,30};
        Code1331 code1331 = new Code1331();
        code1331.arrayRankTransform(arr);
    }
}
