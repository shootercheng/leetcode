package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code1630 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int lenl = l.length;
        List<Boolean> boolList = new ArrayList<>(lenl);
        for (int i = 0; i < lenl; i++) {
            int lindex = l[i];
            int rindex = r[i];
            if (isRightSubArray(nums, lindex, rindex)) {
                boolList.add(true);
            } else {
                boolList.add(false);
            }
        }
        return boolList;
    }

    private boolean isRightSubArray(int[] nums, int lindex, int rindex) {
        List<Integer> numList = new ArrayList<>();
        for (int i = lindex; i <= rindex; i++) {
            numList.add(nums[i]);
        }
        numList = numList.stream().sorted().collect(Collectors.toList());
        int nsize = numList.size();
        if (nsize <= 2) {
            return true;
        }
        int temp = numList.get(1) - numList.get(0);
        for (int i = 2; i < nsize; i++) {
            int subVal = numList.get(i) - numList.get(i - 1);
            if (subVal != temp) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        [-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10]
//        [0,1,6,4,8,7]
//        [4,4,9,7,9,10]
        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = {0,1,6,4,8,7};
        int[] r = {4,4,9,7,9,10};
        Code1630 code1630 = new Code1630();
        System.out.println(code1630.checkArithmeticSubarrays(nums, l, r));
    }
}
