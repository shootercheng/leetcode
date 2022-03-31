package com.scd.exercise.y2021.m7;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code0807 {

    public String[] permutation(String S) {
        char[] charNum = S.toCharArray();
        Set<String> dataSet = new HashSet<>();
        fullPermute(charNum, 0, charNum.length, dataSet);
        String[] dataArr = new String[dataSet.size()];
        int index = 0;
        for (String data : dataSet) {
            dataArr[index++] = data;
        }
        return dataArr;
    }

    public void fullPermute(char[] nums, int startIndex, int len, Set<String> dataSet) {
        if (startIndex == len - 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char num : nums) {
                stringBuilder.append(num);
            }
            String data = stringBuilder.toString();
            dataSet.add(data);
        } else {
            for (int i = startIndex; i < len; i++) {
                swapNum(nums, startIndex, i);
                fullPermute(nums, startIndex + 1, len, dataSet);
                swapNum(nums, i, startIndex);
            }
        }
    }

    private void swapNum(char[] nums, int startIndex, int i) {
        char temp = nums[startIndex];
        nums[startIndex] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        Code0807 code0807 = new Code0807();
        String s = "qwe";
        String[] resultArr = code0807.permutation(s);
        System.out.println(resultArr);
    }
}
