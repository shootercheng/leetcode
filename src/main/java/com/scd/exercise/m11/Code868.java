package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code868 {

    public int binaryGap(int n) {
        String binaryStr = Integer.toBinaryString(n);
        char[] binaryArr = binaryStr.toCharArray();
        int lenb = binaryArr.length;
        int first = -1;
        for (int i = 0; i < lenb; i++) {
            if (binaryArr[i] == '1') {
                first = i;
                break;
            }
        }
        if (first != -1) {
            int index = first;
            int nextIndex = -1;
            int max = Integer.MIN_VALUE;
            for (int i = index + 1; i < lenb; i++) {
                if (binaryArr[i] == '1') {
                    nextIndex = i;
                    int dis = nextIndex - index;
                    if (dis > max) {
                        max = dis;
                    }
                    index = nextIndex;
                }
            }
            if (max != Integer.MIN_VALUE) {
                return max;
            }
        }
        return 0;
    }
}
