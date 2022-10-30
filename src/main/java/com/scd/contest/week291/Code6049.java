package com.scd.contest.week291;

import java.util.HashSet;
import java.util.Set;

/**
 * @author James
 */
public class Code6049 {

    public int countDistinct(int[] nums, int k, int p) {
        int lenn = nums.length;
        int result = 0;
        Set<String> cmbSet = new HashSet<>();
        for (int i = 0; i < lenn; i++) {
            for (int j = i+1; j <= lenn; j++) {
                StringBuilder stringBuilder = new StringBuilder();
                int count = 0;
                for (int m = i; m < j; m++) {
                    stringBuilder.append(nums[m]).append("_");
                    if (nums[m] % p == 0) {
                        count++;
                    }
                }
                String curStr = stringBuilder.toString();
                if (!cmbSet.contains(curStr)) {
                    cmbSet.add(curStr);
                    if (count <= k) {
                        result++;
                    } else {
                        break;
                    }
                }
                System.out.println(stringBuilder);
            }
        }
        return result;
    }

//    [1,9,8,7,19]
//            1
//            6
    public static void main(String[] args) {
        Code6049 code6049 = new Code6049();
        code6049.countDistinct(new int[]{1,9,8,7,19}, 1,6);
    }
}
