package com.scd.exercise.m12;

/**
 * @author James
 */
public class CodeOffer62 {

    public int lastRemaining(int n, int m) {
        // 0 1 2 3 4
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        int pointer = 0;
        int left = n;
        while (true) {
            int count = 0;
            if (left == 1) {
                break;
            }
            while (true) {
                if (array[pointer] != -1) {
                    count++;
                    if (count == m) {
                        // 设置为已经移除了
                        array[pointer] = -1;
                        left--;
                        break;
                    }
                }
                // 移动到数组最后一位, 复位
                if (pointer == n - 1) {
                    pointer = 0;
                } else {
                    pointer++;
                }
            }
        }
        for (int num : array) {
            if (num != -1) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CodeOffer62 codeOffer62 = new CodeOffer62();
        System.out.println(codeOffer62.lastRemaining(5, 3));
    }
}
