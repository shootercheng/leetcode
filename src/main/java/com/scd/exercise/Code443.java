package com.scd.exercise;

/**
 * @author James
 */
public class Code443 {

    public int compress(char[] chars) {
        int clen = chars.length;
        if (clen <= 1) {
            return clen;
        }
        int count = 1;
        char temp = chars[0];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < clen; i++) {
            char curChar = chars[i];
            if (temp == curChar) {
                count++;
            } else {
                stringBuilder.append(temp);
                if (count > 1) {
                    stringBuilder.append(count);
                }
                temp = curChar;
                count = 1;
            }
        }
        stringBuilder.append(temp);
        if (count > 1) {
            stringBuilder.append(count);
        }
        char[] result = stringBuilder.toString().toCharArray();
        int rlen = result.length;
        for (int i = 0; i < rlen; i++) {
            chars[i] = result[i];
        }
        return stringBuilder.length();
    }

    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        Code443 code443 = new Code443();
        System.out.println(code443.compress(chars));
    }
}
