package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class CodeOffer61 {

    public boolean isStraight(int[] nums) {
        List<Integer> dataList = new ArrayList<>();
        int zeroNum = 0;
        for (int n : nums) {
            if (n != 0) {
                dataList.add(n);
            } else {
                zeroNum++;
            }
        }
        dataList = dataList.stream().sorted().collect(Collectors.toList());
        int size = dataList.size();
        int sum = 0;
        for (int i = 0; i < size - 1; i++) {
            int data = dataList.get(i);
            int next = dataList.get(i+1);
            if (next - data == 0) {
                return false;
            }
            int noFoundNum = next - data - 1;
            sum = sum + noFoundNum;
        }
        if (sum == 0 || sum < zeroNum) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CodeOffer61 codeOffer61 = new CodeOffer61();
//        System.out.println(codeOffer61.isStraight(new int[]{1,2,3,4,5}));
//        System.out.println(codeOffer61.isStraight(new int[]{0,0,1,2,5}));
        System.out.println(codeOffer61.isStraight(new int[]{11,0,9,0,0}));
    }
}
