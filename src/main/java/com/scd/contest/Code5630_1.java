package com.scd.contest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code5630_1 {

    public int maximumUniqueSubarray(int[] nums) {
        int lenn = nums.length;
        int startIndex = 0;
        int endIndex = 0;
        int[] countNum = new int[10000];
        int max = 0;
        int sum = 0;
        while(endIndex < lenn) {
            int curNum = nums[endIndex] - 1;
            if (countNum[curNum] == 0) {
                // endIndex = 0 与初始值相同
                countNum[curNum] = endIndex + 1;
                sum = sum + nums[endIndex];
                endIndex = endIndex + 1;
            } else {
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
                int preIndex = countNum[curNum] - 1;
                startIndex = preIndex + 1;
                // 重置索引为0
                countNum = new int[10000];
                endIndex = startIndex;
            }
        }
        if (sum > max) {
            max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        Code5630_1 code5630_1 = new Code5630_1();
        System.out.println(code5630_1.maximumUniqueSubarray(new int[]{4,2,4,5,6}));
    }
}
