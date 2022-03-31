package com.scd.exercise.m10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code1576 {

    private static final List<Character> CHARACTER_LIST = new ArrayList<>();

    static {
        for (int i = 'a'; i < 'a' + 26; i++) {
            CHARACTER_LIST.add((char) i);
        }
    }

    public String modifyString(String s) {
        char[] sArr = s.toCharArray();
        int slen = sArr.length;
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < slen; i++) {
            if (sArr[i] == '?') {
                temp.append('?');
            } else {
                int tlen = temp.length();
                if (tlen > 0) {
                    List<Character> removed = new ArrayList<>();
                    if (i - tlen == 0) {
                        if (i <= slen - 1) {
                            char next = sArr[i];
                            removed.add(next);
                        }
                    } else {
                        char pre = sArr[i - tlen - 1];
                        char next = sArr[i];
                        removed.add(pre);
                        removed.add(next);
                    }
                    appendResult(result, removed, tlen);
                    temp.setLength(0);
                }
                result.append(sArr[i]);
            }
        }
        int tlen = temp.length();
        if (tlen > 0) {
            List<Character> removed = new ArrayList<>();
            if (tlen != slen) {
                char pre = sArr[slen - tlen - 1];
                removed.add(pre);
            }
            appendResult(result, removed, tlen);
        }
        return result.toString();
    }

    private void appendResult(StringBuilder result, List<Character> removed, int tlen) {
        List<Character> resList = new ArrayList<>(CHARACTER_LIST);
        resList.removeAll(removed);
        int rlen = resList.size();
        for (int i = 0; i < tlen; i++) {
            if (i < rlen) {
                result.append(resList.get(i));
            } else {
                int mod = i % rlen;
                result.append(resList.get(mod));
            }
        }
    }

    public static void main(String[] args) {
        Code1576 code1576 = new Code1576();
//        String input1 = "?zs";
//        System.out.println(code1576.modifyString(input1));
//        String input2 = "??????s";
//        System.out.println(code1576.modifyString(input2));
//        String input3 = "ubv?w";
//        System.out.println(code1576.modifyString(input3));
        String input4 = "????????????????????????????????????????????????????????????????????????????????????????????????????";
        System.out.println(code1576.modifyString(input4));
    }
}
