package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code1356 {

    public int[] sortByBits(int[] arr) {
        int lena = arr.length;
        Map<Integer, List<Integer>> oneNumMap = new HashMap<>();
        for (int i = 0; i < lena; i++) {
            int oneCount = countNumOne(arr[i]);
            List<Integer> result = oneNumMap.computeIfAbsent(oneCount, k -> new ArrayList<>());
            result.add(arr[i]);
        }
        List<Integer> keyList = oneNumMap.keySet().stream().sorted().collect(Collectors.toList());
        int[] result = new int[lena];
        int index = 0;
        for (Integer integer : keyList) {
            List<Integer> numList = oneNumMap.get(integer);
            numList = numList.stream().sorted().collect(Collectors.toList());
            for (Integer num : numList) {
                result[index++] = num;
            }
        }
        return result;
    }

    public int countNumOne(int num) {
        int count = 0;
        int temp = num;
        while (temp >= 2) {
            int mod = temp % 2;
            if (mod == 1) {
                count++;
            }
            temp = temp / 2;
        }
        if (temp == 1) {
            count++;
        }
        return count;
    }

//    public int[] frequencySort(int[] nums) {
//        Map<Integer, Integer> countMap = new HashMap<>();
//        for (int num : nums) {
//            Integer count = countMap.computeIfAbsent(num, k -> 0);
//            countMap.put(num, ++count);
//        }
//        Map<Integer, List<Integer>> valueMap = new HashMap<>();
//        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
//        for (Map.Entry<Integer, Integer> entry : entrySet) {
//            Integer count = entry.getValue();
//            List<Integer> keyList = valueMap.computeIfAbsent(count, k -> new ArrayList<>());
//            keyList.add(entry.getKey());
//        }
//        int[] result = new int[nums.length];
//        int index = 0;
//        List<Integer> sortedList = valueMap.keySet().stream().sorted().collect(Collectors.toList());
//        for (Integer count : sortedList) {
//            List<Integer> valueList = valueMap.get(count).stream().sorted().collect(Collectors.toList());
//            for (Integer value : valueList) {
//                for (int i = 0; i < count; i++) {
//                    result[index++] = value;
//                }
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        int num = 4;
        Code1356 code1356 = new Code1356();
        int[] arr = new int[]{0,1,2,3,4,5,6,7,8};
        System.out.println(code1356.sortByBits(arr));
    }
}
