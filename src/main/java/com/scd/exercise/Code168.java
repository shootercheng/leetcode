package com.scd.exercise;

/**
 * @author James
 */
public class Code168 {

    public String convertToTitle(int n) {
        int temp = n - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (temp >= 26) {
            int mod = temp % 26;
            temp = temp / 26;
            stringBuilder.append(mod);
        }
        stringBuilder.append(temp);
        System.out.println(stringBuilder);
        return "";
    }

    public static void main(String[] args) {
        Code168 code168 = new Code168();
        code168.convertToTitle(27);
    }
}
