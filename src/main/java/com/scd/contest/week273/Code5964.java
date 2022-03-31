package com.scd.contest.week273;

/**
 * @author James
 */
public class Code5964 {

    public int[] executeInstructions(int n, int[] startPos, String s) {
        char[] sArr = s.toCharArray();
        int lens = sArr.length;
        int[] result = new int[lens];
        for (int i = 0; i < lens; i++) {
            int x = startPos[1];
            int y = startPos[0];
            int j = i;
            for (; j < lens; j++) {
                if (sArr[j] == 'R') {
                    x = x + 1;
                    if (x == n) {
                        break;
                    }
                } else if (sArr[j] == 'L') {
                    x = x - 1;
                    if (x == -1) {
                        break;
                    }
                } else if (sArr[j] == 'U') {
                    y = y - 1;
                    if (y == -1) {
                        break;
                    }
                } else if (sArr[j] == 'D') {
                    y = y + 1;
                    if (y == n) {
                        break;
                    }
                }
            }
            result[i] = j - i;
        }
        return result;
    }

    public static void main(String[] args) {
        Code5964 code5694 = new Code5964();
        code5694.executeInstructions(3, new int[]{0,1}, "RRDDLU");
    }
}
