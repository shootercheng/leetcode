package com.scd.contest;

/**
 * @author James
 */
public class Code5649 {

    public static void main(String[] args) {
        System.out.println(calOrigin(1, 1));
        System.out.println(calOrigin(0, 2));
        System.out.println(calOrigin(2, 3));
        int[] encodes = new int[2];
        Code5649 code5649 = new Code5649();
        code5649.decode(new int[]{1,2,3}, 1);
    }

    public int[] decode(int[] encoded, int first) {
        int lene = encoded.length;
        int[] result = new int[lene + 1];
        result[0] = first;
        int j = 1;
        for (int i = 0; i < lene; i++) {
            result[j] = calOrigin(result[j-1], encoded[i]);
            j++;
        }
        return result;
    }

    private static int calOrigin(int input, int output) {
        String intStr = Integer.toBinaryString(input);
        String outStr = Integer.toBinaryString(output);
        int leni = intStr.length();
        int leno = outStr.length();
        if (leni > leno) {
            int zeroNum = leni - leno;
            return getResult(intStr, outStr, zeroNum);
        } else {
            int zeroNum = leno - leni;
            return getResult(outStr, intStr, zeroNum);
        }
    }

    private static int getResult(String intStr, String outStr, int zeroNum) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < zeroNum; i++) {
            stringBuilder.append("0");
        }
        stringBuilder.append(outStr);
        int leni = intStr.length();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < leni; i++) {
            char intChar = intStr.charAt(i);
            char outChar = stringBuilder.charAt(i);
            if (outChar == '1' && intChar == '1') {
                result.append('0');
            } else if (outChar == '1' && intChar == '0') {
                result.append('1');
            } else if (outChar == '0' && intChar == '1') {
                result.append('1');
            } else {
                result.append('0');
            }
        }
        return Integer.parseInt(result.toString(), 2);
    }
}
