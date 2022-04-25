package com.scd.exercise.y2022.m4.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 868. 二进制间距
 * @author James
 */
public class Code868 {

    public int binaryGap(int n) {
        String binStr = Integer.toBinaryString(n);
        char[] binArr = binStr.toCharArray();
        int lenb = binArr.length;
        List<Integer> oneIndexList = new ArrayList<>();
        for (int i = 0; i < lenb; i++) {
            if (binArr[i] == '1') {
                oneIndexList.add(i);
            }
        }
        if (oneIndexList.size() <= 1) {
            return 0;
        }
        int temp = oneIndexList.get(0);
        int max = 0;
        for (int i = 1; i < oneIndexList.size(); i++) {
            int cur = oneIndexList.get(i);
            int val = cur - temp;
            if (val > max) {
                max = val;
            }
            temp = cur;
        }
        return max;
    }

    public static void main(String[] args) {
        Code868 code868 = new Code868();
        code868.binaryGap(22);
    }
}
