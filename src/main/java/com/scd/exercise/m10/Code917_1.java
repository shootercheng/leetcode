package com.scd.exercise.m10;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author James
 */
public class Code917_1 {

    public String reverseOnlyLetters(String S) {
        char[] scharArr = S.toCharArray();
        int lens = scharArr.length;
        if (lens <= 1) {
            return S;
        }
        int i = 0;
        int j = lens - 1;
        while (true) {
            while (!Character.isLetter(scharArr[i])) {
                i++;
                if (i == lens - 1) {
                    break;
                }
            }
            while (!Character.isLetter(scharArr[j])) {
                j--;
                if (j == 0) {
                    break;
                }
            }
            if (i < j) {
                char temp = scharArr[i];
                scharArr[i] = scharArr[j];
                scharArr[j] = temp;
                i++;
                j--;
            } else {
                break;
            }
        }
        return new String(scharArr);
    }

    public static void main(String[] args) {
//        dc-ba
//        j-Ih-gfE-dCba
//        Qedo1ct-eeLg=ntse-T!
        Code917_1 code917 = new Code917_1();
        System.out.println(code917.reverseOnlyLetters("ab-cd"));
        System.out.println(code917.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(code917.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(code917.reverseOnlyLetters("7_28]"));
    }
}
