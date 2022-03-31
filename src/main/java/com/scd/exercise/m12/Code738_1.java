package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code738_1 {

    public int monotoneIncreasingDigits(int N) {
        if (N < 10) {
            return N;
        }
        List<Integer> numList = convertNumList(N);
        int ascIndex = -1;
        int start = numList.get(0);
        int lenn = numList.size();
        for (int i = 1; i < lenn; i++) {
            int next = numList.get(i);
            if (next < start) {
                ascIndex = i;
                break;
            }
            start = next;
        }
        // 无下降序列
        if (ascIndex == -1) {
            return N;
        }
        // 最后两位下降了
        if (numList.get(lenn -2) > numList.get(lenn - 1)) {
            return numList.get(0) * (int) Math.pow(10, lenn - 1) - 1;
        } else {

        }
        return N;
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
