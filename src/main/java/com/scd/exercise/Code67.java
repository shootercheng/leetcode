package com.scd.exercise;

/**
 * @author James
 */
public class Code67 {

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return "";
        }
        if (b == null || b.length() == 0) {
            return "";
        }
        int aInt = Integer.parseInt(a, 2);
        int bInt = Integer.parseInt(b, 2);
        int result = aInt + bInt;
        return Integer.toBinaryString(result);
    }

    public static void main(String[] args) {
        Code67 code67 = new Code67();
        System.out.println(code67.addBinary("11", "1"));
        System.out.println(code67.addBinary("1010", "1011"));
        System.out.println(code67.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}
