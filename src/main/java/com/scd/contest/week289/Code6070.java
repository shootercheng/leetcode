package com.scd.contest.week289;

/**
 * @author James
 */
public class Code6070 {

    public String digitSum(String s, int k) {
        while (s.length() > k) {
            s = merge(s, k);
        }
        return s;
    }

    private String merge(String s, int k) {
        int lens = s.length();
        StringBuilder stringBuilder = new StringBuilder();
        while (lens > k) {
            String curs = s.substring(0, k);
            int sum = getSum(curs);
            stringBuilder.append(sum);
            s = s.substring(k);
            lens = s.length();
        }
        if (lens != 0) {
            stringBuilder.append(getSum(s));
        }
        return stringBuilder.toString();
    }

    private int getSum(String curs) {
        char[] charArr = curs.toCharArray();
        int sum = 0;
        for (char curChar : charArr) {
            sum = sum + curChar - 48;
        }
        return sum;
    }

    public static void main(String[] args) {
        Code6070 code6070 = new Code6070();
        code6070.digitSum("11111222223", 3);
        System.out.println();
    }
}
