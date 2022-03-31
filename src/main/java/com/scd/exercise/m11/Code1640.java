package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int lena = arr.length;
        int lenp = pieces.length;
        boolean[] matched = new boolean[lena];
        for (int i = 0; i < lenp; i++) {
            int lensubp = pieces[i].length;
            if (lensubp == 0) {
                continue;
            } else if (lensubp == 1) {
                int index = findArrIndex(arr, pieces[i][0], matched);
                if (index == -1) {
                    return false;
                }
            } else {
                int index = findArrIndex(arr, pieces[i][0], matched);
                if (index == -1) {
                    return false;
                }
                int nextIndex = -1;
                for (int j = 1; j < lensubp; j++) {
                    nextIndex = findArrIndex(arr, pieces[i][j], matched);
                    if (nextIndex == -1) {
                        return false;
                    }
                    if (nextIndex - index != 1) {
                        return false;
                    }
                    index = nextIndex;
                }
            }
        }
        for (boolean match : matched) {
            if (!match) {
                return false;
            }
        }
        return true;
    }

    private int findArrIndex(int[] arr, int i, boolean[] matched) {
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == i && !matched[j]) {
                matched[j] = true;
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {85};
        int[][] pieces = new int[][]{{85}};
        Code1640 code1640 = new Code1640();
//        System.out.println(code1640.canFormArray(arr, pieces));
//        [37,69,3,74,46]
//        [[37,69,3,74,46]]
        System.out.println(code1640.canFormArray(new int[]{37,69,3,74,46}, new int[][]{{37,69,3,74,46}}));
    }
}
