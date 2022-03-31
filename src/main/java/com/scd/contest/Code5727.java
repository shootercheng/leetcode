package com.scd.contest;

/**
 * @author James
 */
public class Code5727 {

    public int findTheWinner(int n, int k) {
        int[] dataArr = new int[n];
        int removed = 0;
        int i = 0;
        int count = 0;
        while (removed != n - 1) {
            if (dataArr[i] != 1) {
                count++;
                if (count == k) {
                    removed++;
                    dataArr[i] = 1;
                    i = findNextIndex(i + 1, dataArr);
                    if (i == -1) {
                        break;
                    }
                    count = 0;
                    continue;
                }
            }
            if (i == n - 1) {
                i = 0;
                continue;
            }
            i++;
        }
        for (int j = 0; j < n; j++) {
            if (dataArr[j] == 0) {
                return j + 1;
            }
        }
        return -1;
    }

    private int findNextIndex(int start, int[] dataArr) {
        int lend = dataArr.length;
        for (int i = start; i < lend; i++) {
            if (dataArr[i] == 0) {
                return i;
            }
        }
        for (int i = 0; i < start; i++) {
            if (dataArr[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Code5727 code5727 = new Code5727();
        System.out.println(code5727.findTheWinner(5, 2));
        System.out.println(code5727.findTheWinner(6, 5));
        System.out.println(code5727.findTheWinner(3, 1));
        System.out.println(code5727.findTheWinner(5, 3));
    }
}
