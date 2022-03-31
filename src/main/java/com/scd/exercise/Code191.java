package com.scd.exercise;

/**
 * @author James
 */
public class Code191 {

    public int hammingWeight(int n) {
        String binaryStr = Integer.toUnsignedString(n, 2);
        char[] binaryArr = binaryStr.toCharArray();
        int count = 0;
        for (char c : binaryArr) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Code191 code191 = new Code191();
        int result = code191.hammingWeight(00000000000000000000000000001011);
        System.out.println(result);
    }
}
