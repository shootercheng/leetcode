package com.scd.exercise.y2022.m4.easy;

/**
 * 1566. 重复至少 K 次且长度为 M 的模式
 * @author James
 */
public class Code1566 {

    public boolean containsPattern(int[] arr, int m, int k) {
        int lena = arr.length;
        int tempLength = m * k;
        for (int i = 0; i < lena; i++) {
            int[] tempArr = new int[tempLength];
            int tempIndex = 0;
            for (int j = i; j < i + tempLength && j < lena; j++) {
                tempArr[tempIndex++] = arr[j];
            }
            if (tempIndex != tempLength - 1) {
                continue;
            }
            if (isRight(tempArr, m, k)) {
                return true;
            }
        }
        return false;
    }

    public boolean isRight(int[] tempArr, int m, int k) {
        boolean isFirst = true;
        int[] matchArr = new int[m];
        for (int i = 0; i < tempArr.length; i = i + m) {
            if (isFirst) {
                int tempIndex = 0;
                for (int j = i; j < i+m; j++) {
                    matchArr[tempIndex++] = tempArr[j];
                }
                isFirst = false;
            } else {
                int tempIndex = 0;
                for (int j = i; j < i+m; j++) {
                    if (matchArr[tempIndex++] != tempArr[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Code1566 code1566 = new Code1566();
        code1566.containsPattern(new int[]{1,2,1,2,1,1,1,3}, 2, 2);
    }
}
