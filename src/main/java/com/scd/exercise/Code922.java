package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code922 {

    public int[] sortArrayByParityII(int[] A) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for (int i : A) {
            if (i % 2 == 0) {
                evenList.add(i);
            } else {
                oddList.add(i);
            }
        }
        int lena = A.length;
        int[] result = new int[lena];
        int leneven = evenList.size();
        int j = 0;
        for (int i = 0; i < leneven; i++) {
            result[j] = evenList.get(i);
            result[j+1] = oddList.get(i);
            j = j + 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] inputArr = new int[]{4,2,5,7};
        Code922 code922 = new Code922();
        int[] res = code922.sortArrayByParityII(inputArr);
        System.out.println(res);
    }
}
