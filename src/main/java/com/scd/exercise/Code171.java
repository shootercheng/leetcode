package com.scd.exercise;

/**
 * @author James
 */
public class Code171 {

    public int titleToNumber(String s) {
        if (s == null) {
            return 0;
        }
        char[] charArr = s.toCharArray();
        int i = charArr.length - 1;
        int result = 0;
        for (char c : charArr) {
            result = result + (int) Math.pow(26, i--) * ((int) c % 64);
        }
        return result;
    }

    public void calTwentySix(int inputNum) {
        int temp = inputNum;
        while (temp > 26) {
            int mod = temp % 26;
            temp = temp / 26;
        }
    }

    public static void main(String[] args) {
        String columnStr = "AB";        // 1 * 26^1 + 2 * 26^0 = 28
        // A --> 65  65 % 64 = 1
        // B --> 66  66 % 64 = 2
        Code171 code171 = new Code171();
        System.out.println(code171.titleToNumber(columnStr));
    }
}
