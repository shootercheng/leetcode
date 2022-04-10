package com.scd.exercise.y2022.m4.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 剑指 Offer II 075. 数组相对排序
 * @author James
 */
public class CodeOffer075 {
    private Map<Integer, Integer> orderMap;

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        orderMap = new HashMap<>();
        int lena = arr2.length;
        for (int i = 0; i < lena; i++) {
            orderMap.put(arr2[i], i);
        }
        List<Integer> orderList = new ArrayList<>();
        List<Integer> otherList = new ArrayList<>();
        for (int num : arr1) {
            if (orderMap.containsKey(num)) {
                orderList.add(num);
            } else {
                otherList.add(num);
            }
        }
        orderList = orderList.stream().sorted(this::sort).collect(Collectors.toList());
        otherList = otherList.stream().sorted().collect(Collectors.toList());
        int[] result = new int[arr1.length];
        int osize = orderList.size();
        for (int i = 0; i < osize; i++) {
            result[i] = orderList.get(i);
        }
        for (int i = 0; i < otherList.size(); i++) {
            result[osize + i] = otherList.get(i);
        }
        return result;
    }

    private int sort(Integer a, Integer b) {
        Integer vala = orderMap.get(a);
        Integer valb = orderMap.get(b);
        if (vala == null) {
            return -1;
        }
        if (valb == null) {
            return 1;
        }
        if (vala > valb) {
            return 1;
        } else if (vala.intValue() == valb.intValue()) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        CodeOffer075 codeOffer075 = new CodeOffer075();
        codeOffer075.relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6});
    }
}
