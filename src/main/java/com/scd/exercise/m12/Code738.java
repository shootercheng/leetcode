package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code738 {

    public int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        }
        List<Integer> numList = convertNumList(N);
        if (isNumAsc(numList)) {
            return N;
        }
        int maxNum = N - 1;
        int minNum = 0;
        int first = numList.get(0);
        int size = numList.size();
        // 1 开头取一个区间 比如 1232 取 [999, 1231]
        if (first == 1) {
            minNum = (int) Math.pow(10, size - 1) - 1;
        } else {
            minNum = first * (int) Math.pow(10, size - 1) - 1;
        }
        int ascMaxNum = minNum;
        for (int i = minNum + 1; i <= maxNum; i++) {
            List<Integer> curList = convertNumList(i);
            if (isNumAsc(curList) && i > ascMaxNum) {
                ascMaxNum = i;
            }
        }
        return ascMaxNum;
    }

    private boolean isNumAsc(List<Integer> numList) {
        int start = numList.get(0);
        int lenn = numList.size();
        for (int i = 1; i < lenn; i++) {
            int next = numList.get(i);
            if (next < start) {
                return false;
            }
            start = next;
        }
        return true;
    }

    private List<Integer> convertNumList(int n) {
        List<Integer> result = new ArrayList<>();
        int temp = n;
        while (temp >= 10) {
            int mod = temp % 10;
            temp = temp / 10;
            result.add(0, mod);
        }
        int mod = temp % 10;
        result.add(0, mod);
        return result;
    }

    public static void main(String[] args) {
        Code738 code738 = new Code738();
        System.out.println(code738.monotoneIncreasingDigits(987654321));
    }
}
