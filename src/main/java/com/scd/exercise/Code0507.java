package com.scd.exercise;

/**
 * @author James
 */
public class Code0507 {

    public int exchangeBits(int num) {
        String binaryStr = Integer.toBinaryString(num);
        int clen = binaryStr.length();
        if (clen % 2 != 0) {
            binaryStr = "0" + binaryStr;
            clen = clen + 1;
        }
        char[] charArr = binaryStr.toCharArray();
        for (int i = 0; i < clen; i = i+2) {
            char temp = charArr[i];
            charArr[i] = charArr[i+1];
            charArr[i+1] = temp;
        }
        String res = new String(charArr);
        return Integer.parseInt(res, 2);
    }

    public static void main(String[] args) {
        Code0507 code0507 = new Code0507();
        System.out.println(code0507.exchangeBits(2));
        System.out.println(code0507.exchangeBits(3));
        System.out.println(code0507.exchangeBits(7));
    }
}
