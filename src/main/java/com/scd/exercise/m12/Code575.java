package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code575 {

    public int distributeCandies(int[] candies) {
        Map<Integer, Integer> candiesTypeMap = new HashMap<>();
        for (int candie : candies) {
            Integer count = candiesTypeMap.computeIfAbsent(candie, k -> 0);
            candiesTypeMap.put(candie, ++count);
        }
        int lenc = candies.length;
        int half = lenc / 2;
        int mapSize = candiesTypeMap.size();
        if (mapSize >= half) {
            return half;
        } else {
            return mapSize;
        }
    }

    public static void main(String[] args) {
        int[] input = {1,1,2,2,3,3};
        Code575 code575 = new Code575();
        System.out.println(code575.distributeCandies(input));
    }
}
