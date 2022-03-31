package com.scd.contest.week273;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code5965 {

    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>(16);
        int lena = arr.length;
        for (int i = 0; i < lena; i++) {
            List<Integer> indexList = numIndexMap.computeIfAbsent(arr[i], k -> new ArrayList<>());
            indexList.add(i);
        }
        long[] resultArr = new long[lena];
        for (int i = 0; i < lena; i++) {
            List<Integer> indexList = numIndexMap.get(arr[i]);
            long result = 0;
            for (Integer index : indexList) {
                if (index != i) {
                    result = result + Math.abs(index - i);
                }
            }
            resultArr[i] = result;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        Code5965 code5965 = new Code5965();
        code5965.getDistances(new int[]{2,1,3,1,2,3,3});
    }
}
