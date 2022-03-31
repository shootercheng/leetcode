package com.scd.contest.week255;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code5851 {

    public String findDifferentBinaryString(String[] nums) {
        int lenn = nums.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < lenn; i++) {
            stringBuilder.append("1");
        }
        int num = Integer.parseInt(stringBuilder.toString(), 2);
        Set<String> numSet = new HashSet<>();
        for (int i = 0; i <= num; i++) {
            numSet.add(calBinaryStr(i, lenn));
        }
        for (String n : nums) {
            numSet.remove(n);
        }
        return numSet.iterator().next();
    }

    public String calBinaryStr(int inputNum, int len) {
        String binaryStr = Integer.toBinaryString(inputNum);
        int zeroNum = len - binaryStr.length();
        if (zeroNum <= 0) {
            return binaryStr;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < zeroNum; i++) {
            stringBuilder.append("0");
        }
        return stringBuilder.toString() + binaryStr;
    }

    public static void main(String[] args) {
        String[] nums = {"0"};
        Code5851 code5851 = new Code5851();
        System.out.println(code5851.findDifferentBinaryString(nums));
    }
}
