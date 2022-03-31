package com.scd.contest;

/**
 * @author James
 */
public class Code5838 {

    public boolean isPrefixString(String s, String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        int lenw = words.length;
        for (int i = 0; i < lenw; i++) {
            stringBuilder.append(words[i]);
            String temp = stringBuilder.toString();
            if (!s.startsWith(temp)) {
                return false;
            }
            if (temp.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "a";
        String[] words = {"aa","aaaa","banana"};
        Code5838 code5838 = new Code5838();
        System.out.println(code5838.isPrefixString(s, words));
    }
}
