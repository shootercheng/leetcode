package com.scd.book.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class ExTopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int n : nums) {
            Integer count = map.computeIfAbsent(n, l -> 0);
            map.put(n, ++count);
        }
        List<Map.Entry<Integer, Integer>> entryList = map.entrySet().stream()
                .sorted(this::sortVal).collect(Collectors.toList());
        int[] result = new int[k];
        int lene = entryList.size();
        for (int i = 0; i < k; i++) {
            result[i] = entryList.get(lene - i - 1).getKey();
        }
        return result;
    }

    private int sortVal(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
        return e1.getValue() - e2.getValue();
    }

    public static void main(String[] args) {
        ExTopKFrequent exTopKFrequent = new ExTopKFrequent();
        int[] nums = {1,1,1,2,2,3};
        exTopKFrequent.topKFrequent(nums, 2);
    }
}
