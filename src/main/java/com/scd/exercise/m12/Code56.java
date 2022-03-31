package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * @author James
 */
public class Code56 {

    public int[][] merge(int[][] intervals) {
        int leni = intervals.length;
        if (leni <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(this::sort));
        List<int[]> result = new ArrayList<>();
        int[] start = intervals[0];
        int[] next = intervals[1];
        mergeTwoArr(start, next, result, true);
        int startIndex = 2;
        while (startIndex < leni) {
            int[] curStart = result.get(result.size() - 1);
            mergeTwoArr(curStart, intervals[startIndex], result, false);
            startIndex++;
        }
        int size = result.size();
        int[][] resultArr = new int[size][2];
        for (int i = 0; i < size; i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }

    private void mergeTwoArr(int[] start, int[] next, List<int[]> result, boolean isFirst) {
        if (next[0] > start[1]) {
            if (isFirst) {
                result.add(start);
            }
            result.add(next);
        } else if (next[1] >= start[1]) {
            int[] merge = new int[]{start[0], next[1]};
            if (result.size() > 0) {
                result.remove(result.size() - 1);
            }
            result.add(merge);
        } else {
            if (isFirst) {
                result.add(start);
            }
        }
    }

    private int sort(int[] t) {
        return t[0];
    }

    public static void main(String[] args) {
        int[][] martix = {
                {1,4},
                {2,3}
        };
        Code56 code56 = new Code56();
        System.out.println(code56.merge(martix));
    }


}
