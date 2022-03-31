package com.scd.contest.week241;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code5759 {

    public int subsetXORSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] result = new int[1];
        cal(nums, list, 0, result);
        return result[0];
    }

    private void cal(int[] arr, List<Integer> list, int index, int[] result) {
        addxorResult(list, result);
        if (list.size() == arr.length) {
            return;
        }
        for (int i = index; i < arr.length; i++) {
            list.add(arr[i]);
            cal(arr, list, i + 1, result);
            list.remove(list.size() - 1);
        }
    }

    private void addxorResult(List<Integer> list, int[] result) {
        int temp = 0;
        for (Integer num : list) {
            temp = temp ^ num;
        }
        result[0] = result[0] + temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,8};
        Code5759 code5759 = new Code5759();
        System.out.println(code5759.subsetXORSum(arr));
        System.out.println(code5759.subsetXORSum(new int[]{1,3}));
        System.out.println(code5759.subsetXORSum(new int[]{5,1,6}));
        System.out.println(code5759.subsetXORSum(new int[]{}));
    }
}
