package com.scd.exercise;

/**
 * @author James
 */
public class Code461 {

    public int hammingDistance(int x, int y) {
        String xstr = Integer.toBinaryString(x);
        String ystr = Integer.toBinaryString(y);
        int xlen = xstr.length();
        int ylen = ystr.length();
        int loop;
        if (xlen > ylen) {
            int zeroNum = xlen - ylen;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < zeroNum; i++) {
                stringBuilder.append("0");
            }
            ystr = stringBuilder + ystr;
            loop = xlen;
        } else {
            int zeroNum = ylen - xlen;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < zeroNum; i++) {
                stringBuilder.append("0");
            }
            xstr = stringBuilder + xstr;
            loop = ylen;
        }
        char[] xstrArr = xstr.toCharArray();
        char[] ystrArr = ystr.toCharArray();
        int count = 0;
        for (int i = 0; i < loop; i++) {
            if (xstrArr[i] != ystrArr[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Code461 code461 = new Code461();
        System.out.println(code461.hammingDistance(1, 4));
    }
}
