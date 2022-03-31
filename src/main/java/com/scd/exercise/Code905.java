package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code905 {

    public int[] sortArrayByParity(int[] A) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i : A) {
            if (i % 2 == 0) {
                list1.add(i);
            } else {
                list2.add(i);
            }
        }
        int list1Size = list1.size();
        int list2Size = list2.size();
        int[] result = new int[list1Size + list2Size];
        for (int i = 0; i < list1Size; i++) {
            result[i] = list1.get(i);
        }
        for (int i = 0; i < list2Size; i++) {
            result[list1Size + i] = list2.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Code905 code905 = new Code905();
        int[] A = {3,1,2,4};
        int[] result = code905.sortArrayByParity(A);
        System.out.println(result);
    }
}
