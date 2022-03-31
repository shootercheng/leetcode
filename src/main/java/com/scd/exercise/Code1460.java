package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code1460 {

    public boolean canBeEqual(int[] target, int[] arr) {
        if (target == null || arr == null) {
            return false;
        }
        int lent = target.length;
        int lena = arr.length;
        if (lent != lena) {
            return false;
        }
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < lent; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] target = {1,2,3,4};
        int[] arr = {2,4,1,3};
        Code1460 code1460 = new Code1460();
        boolean result = code1460.canBeEqual(target, arr);
        System.out.println(result);
    }
}
