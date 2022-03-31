package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class MCode1611 {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        Set<Integer> resultSet = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            int j = k - i;
            int result = longer * i + shorter * j;
            if (!resultSet.contains(result)) {
                list.add(result);
                resultSet.add(result);
            }
        }
        int[] resultArr = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            resultArr[i++] = integer;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        MCode1611 mCode1611 = new MCode1611();
        System.out.println(mCode1611.divingBoard(1,2,3));
    }
}
