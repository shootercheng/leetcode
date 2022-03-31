package com.scd.exercise.y2021.m7;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author James
 */
public class Code1859 {

    public String sortSentence(String s) {
        String[] strArr = s.split("\\s+");
        Arrays.sort(strArr, this::compare);
        StringBuilder stringBuilder = new StringBuilder("");
        int len = strArr.length;
        for (int i = 0; i < len; i++) {
            String subWord = strArr[i].substring(0, strArr[i].length() - 1);
            stringBuilder.append(subWord);
            if (i != len - 1) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public int compare(String o1, String o2) {
        int num1 = Integer.parseInt(o1.substring(o1.length() - 1));
        int num2 = Integer.parseInt(o2.substring(o2.length() - 1));
        return num1 - num2;
    }

    public static void main(String[] args) {
        Code1859 code1859 = new Code1859();
        System.out.println(code1859.sortSentence("is2 sentence4 This1 a3"));
    }
}
