package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class CodeOffer57 {

    public int[][] findContinuousSequence(int target) {
        int max = target / 2 + 1;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            int sum = 0;
            for (int j = i; j <= max; j++) {
                sum = sum + j;
                if (sum > target) {
                    break;
                }
                if (sum == target) {
                    List<Integer> oneCombine = new ArrayList<>();
                    for (int start = i; start <= j; start++) {
                        oneCombine.add(start);
                    }
                    result.add(oneCombine);
                }
            }
        }
        int size = result.size();
        int[][] intres = new int[size][];
        for (int i = 0; i < size; i++) {
            intres[i] = new int[result.get(i).size()];
            for (int j = 0; j < result.get(i).size(); j++) {
                intres[i][j] = result.get(i).get(j);
            }
        }
        return intres;
    }

    public static void main(String[] args) {
        CodeOffer57 codeOffer57 = new CodeOffer57();
        codeOffer57.findContinuousSequence(15);
    }
}
