package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code844 {

    public boolean backspaceCompare(String S, String T) {
        char[] scharArr = S.toCharArray();
        char[] tcharArr = T.toCharArray();
        removeChar(scharArr);
        removeChar(tcharArr);
        String str = getStr(scharArr);
        String tstr = getStr(tcharArr);
        return str.equals(tstr);
    }

    private String getStr(char[] scharArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : scharArr) {
            if (c != '_') {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    private void removeChar(char[] scharArr) {
        int slen = scharArr.length;
        for (int i = 0; i < slen; i++) {
            if (scharArr[i] == '#') {
                scharArr[i] = '_';
                for (int j = i - 1; j >= 0; j--) {
                    if (Character.isLetter(scharArr[j])) {
                        scharArr[j] = '_';
                        break;
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        Code844 code844 = new Code844();
//        "isfcow#"
//        "isfco#w#"
        System.out.println(code844.backspaceCompare("isfcow#", "isfco#w#"));
    }
}
