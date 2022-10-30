package com.scd.exercise.y2022.m5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code937 {

    public String[] reorderLogFiles(String[] logs) {
        List<String> charLogList = new ArrayList<>();
        List<String> numLogList = new ArrayList<>();
        String[] result = new String[logs.length];
        for (String log : logs) {
            if (isNumLog(log)) {
                numLogList.add(log);
            } else {
                charLogList.add(log);
            }
        }
        charLogList = charLogList.stream().sorted(this::sort).collect(Collectors.toList());
        int index = 0;
        while (index < charLogList.size()) {
            result[index] = charLogList.get(index);
            index++;
        }
        int j = 0;
        while (j < numLogList.size()) {
            result[index++] = numLogList.get(j);
            j++;
        }
        return result;
    }

    private int sort(String s1, String s2) {
        int s1SuffixIndex = suffixIndex(s1);
        int s2SufficIndex = suffixIndex(s2);
        String s1Content = s1.substring(s1SuffixIndex + 1);
        String s2Content = s2.substring(s2SufficIndex + 1);
        if (s1Content.equals(s2Content)) {
            String s1Suffix = s1.substring(0, s1SuffixIndex);
            String s2Suffix = s2.substring(0, s2SufficIndex);
            return s1Suffix.compareTo(s2Suffix);
        } else {
            return s1Content.compareTo(s2Content);
        }
    }

    private int suffixIndex(String s) {
        return s.indexOf(" ");
    }


    private boolean isNumLog(String log) {
        int index = log.indexOf(" ");
        if (index != -1) {
            int nextIndex  = index + 1;
            char ch = log.charAt(nextIndex);
            return Character.isDigit(ch);
        }
        return false;
    }

    public static void main(String[] args) {
        Code937 code937 = new Code937();
        code937.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig",
                "let3 art zero", "let5 art can"});
    }
}
