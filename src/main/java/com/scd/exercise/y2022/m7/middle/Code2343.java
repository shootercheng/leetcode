package com.scd.exercise.y2022.m7.middle;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 裁剪数字后查询第 K 小的数字
 * @author James
 */
public class Code2343 {

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int lenq = queries.length;
        int[] result = new int[lenq];
        for (int i = 0; i < lenq; i++) {
            int[] curArr = queries[i];
            result[i] = calCurArr(nums, curArr);
        }
        return result;
    }

    private int calCurArr(String[] nums, int[] curArr) {
        int cutNum = curArr[1];
        List<BigInteger[]> numList = new ArrayList<>(nums.length);
        int lenn = nums[0].length();
        int index = 0;
        for (String num : nums) {
            String cutStr;
            if (cutNum == lenn) {
                cutStr = num;
            } else {
                cutStr = num.substring(lenn - cutNum);
            }
            numList.add(new BigInteger[]{new BigInteger(cutStr), new BigInteger(String.valueOf(index++))});
        }
        numList.sort((arr1, arr2) -> {
            if (arr1[0].equals(arr2[0])) {
                return arr1[1].compareTo(arr2[1]);
            } else {
                return arr1[0].compareTo(arr2[0]);
            }
        });
        return numList.get(curArr[0] - 1)[1].intValue();
    }

    public static void main(String[] args) {
        String[] nums = {"24","37","96","04"};
        int[][] queries = new int[][]{{2,1},{2,2}};
        Code2343 code2343 = new Code2343();
        code2343.smallestTrimmedNumbers(nums, queries);
    }
}
