package com.scd.encrypt;

/**
 * @author James
 */
public class RadixUtil {

    public String convertTenToN(int input, int radix) {
        StringBuilder stringBuilder = new StringBuilder();
        while (input >= radix) {
            int mod = input % radix;
            stringBuilder.append(mod);
            input = input / radix;
        }
        stringBuilder.append(input);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        RadixUtil radixUtil = new RadixUtil();
        System.out.println(radixUtil.convertTenToN(8, 2));
        System.out.println(Integer.toBinaryString(8));
    }
}
