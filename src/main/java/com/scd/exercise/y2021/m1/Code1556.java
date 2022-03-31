package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class Code1556 {

    public String thousandSeparator(int n) {
        String nstr = String.valueOf(n);
        StringBuilder result = new StringBuilder();
        char[] nstrCharArr = nstr.toCharArray();
        int count = 0;
        for (int i = nstrCharArr.length - 1; i >= 0; i--) {
            if (count == 3) {
                count = 0;
                result.append(".");
            }
            result.append(nstrCharArr[i]);
            count++;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Code1556 code1556 = new Code1556();
//        System.out.println(code1556.thousandSeparator(987));
//        System.out.println(code1556.thousandSeparator(1234));
        System.out.println(code1556.thousandSeparator(123456789));
        System.out.println(code1556.thousandSeparator(0));
    }
}
