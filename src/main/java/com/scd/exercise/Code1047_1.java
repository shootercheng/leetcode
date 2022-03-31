package com.scd.exercise;

/**
 * @author James
 */
public class Code1047_1 {

    public String removeDuplicates(String S) {
        while (hasRepeate(S)) {
            String temp = S;
            char[] tempArr = temp.toCharArray();
            int loop = tempArr.length - 1;
            int end = -1;
            int start = -1;
            for (int i = 0; i < loop; i++) {
                if (tempArr[i] == tempArr[i+1]) {
                    end = i;
                    start = i+1;
                }
            }
            if (start != -1 && end != -1) {
                S = S.substring(0, end) + S.substring(start + 1);
            }

        }
        return S;
    }

    public boolean hasRepeate(String s) {
        char[] scharArr = s.toCharArray();
        int loop = scharArr.length - 1;
        for (int i = 0; i < loop; i++) {
            if (scharArr[i] == scharArr[i+1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaa";
        Code1047_1 code1047 = new Code1047_1();
        System.out.println(code1047.removeDuplicates(s));
    }
}
