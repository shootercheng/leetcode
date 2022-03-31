package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1047 {

    public String removeDuplicates(String S) {
        while (hasRepeate(S)) {
            String temp = S;
            char[] tempArr = temp.toCharArray();
            int startIndex = 0;
            int count = 1;
            char first = tempArr[0];
            int loop = tempArr.length;
            boolean isSame = false;
            for (int i = 1; i < loop; i++) {
                if (tempArr[i] == first) {
                    if (!isSame) {
                        startIndex = i - 1;
                    }
                    count++;
                    isSame = true;
                } else {
                    if (isSame) {
                        S = S.substring(0, startIndex) + S.substring(startIndex + count);
                        isSame = false;
                        break;
                    }
                    first = tempArr[i];
                    count = 1;
                }
            }
            if (isSame) {
                S = S.substring(0, startIndex) + S.substring(startIndex + count);
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
        String s = "aaaaaaa";
        Code1047 code1047 = new Code1047();
        System.out.println(code1047.removeDuplicates(s));
    }
}
