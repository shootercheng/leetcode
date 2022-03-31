package com.scd.exercise;

/**
 * @author James
 */
public class Code344 {

    public void reverseString(char[] s) {
        int len = s.length;
        int center = len / 2;
        int mod = len % 2;
        if (mod != 0) {
            for (int i = 0, j = len - 1; i <= center; i++, j--) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }
        } else {
            for (int i = 0, j = len - 1; i < center; i++, j--) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        char[] input1 = {'h','e','l','l'};
        Code344 code344 = new Code344();
        code344.reverseString(input1);
        System.out.println(input1);
    }
}
