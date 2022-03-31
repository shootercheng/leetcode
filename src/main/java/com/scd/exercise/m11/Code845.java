package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code845 {

    public int longestMountain(int[] A) {
        int startIndex = 0;
        int endIndex = -1;
        int max = 0;
        int lena = A.length;
        while (startIndex < lena) {
            int mountMax = -1;
            boolean isAsc = false;
            boolean isDesc = false;
            for (int i = startIndex; i < lena - 1; i++) {
                if (A[i+1] > A[i]) {
                    isAsc = true;
                } else {
                    mountMax = i;
                    break;
                }
            }
            if (isAsc && mountMax != -1) {
                for (int i = mountMax; i < lena - 1; i++) {
                    if (A[i+1] < A[i]) {
                        isDesc = true;
                    } else {
                        endIndex = i;
                        break;
                    }
                }
                // 下降到最后一个字符
                if (isDesc && endIndex == - 1) {
                    endIndex = lena - 1;
                }
            }
            if (isDesc) {
                int dis = endIndex - startIndex + 1;
                if (dis > max) {
                    max = dis;
                }
            }
            if (endIndex != -1) {
                startIndex = endIndex;
                endIndex = -1;
            } else {
                startIndex++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Code845 code845 = new Code845();
        System.out.println(code845.longestMountain(new int[]{875,884,239,731,723,685}));
    }
}
