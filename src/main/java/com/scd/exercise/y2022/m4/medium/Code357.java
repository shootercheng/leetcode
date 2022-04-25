package com.scd.exercise.y2022.m4.medium;

/**
 * 357.统计各位数字都不同的数字个数
 * @author James
 */
public class Code357 {

    public int countNumbersWithUniqueDigits(int n) {
        int sum = 1;
        for (int i = 0; i < n; i++) {
            sum = sum * 10;
        }
        int loop = sum;
        for (int i = 10; i < loop; i++) {
            boolean isSame = isSameChar(i);
            if (isSame) {
                sum--;
            }
        }
        return sum;
    }

    private boolean isSame(int i) {
        int[] count = new int[10];
        int temp = i;
        while (temp > 9) {
            int mod = temp % 10;
            if (count[mod] == 1) {
                return true;
            }
            temp = temp / 10;
            count[mod]++;
        }
        if (count[temp] == 1) {
            return true;
        }
        return false;
    }

    private boolean isSameChar(int i) {
        String numStr = String.valueOf(i);
        char[] numArrChar = numStr.toCharArray();
        int[] count = new int[10];
        for (char num : numArrChar) {
            if (count[num - '0'] == 1) {
                return true;
            }
            count[num - '0']++;
        }
        return false;
    }

    public static void main(String[] args) {
        Code357 code357 = new Code357();
        for (int i = 10; i < 100; i++) {
            if (code357.isSameChar(i)) {
                System.out.println(i + "—" + code357.isSameChar(i));
            }
        }
        code357.countNumbersWithUniqueDigits(8);
    }
}
