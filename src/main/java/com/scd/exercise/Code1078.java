package com.scd.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code1078 {

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split("\\s+");
        int lenw = words.length;
        int loop = lenw - 2;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < loop; i++) {
            if (words[i].equals(first) && words[i+1].equals(second)) {
                result.add(words[i+2]);
            }
        }
        String[] sArr = new String[result.size()];
        return result.toArray(sArr);
    }

    public static void main(String[] args) {
        String text = "alice is a good girl she is a good student";
        Code1078 code1078 = new Code1078();
        code1078.findOcurrences(text, "a", "good");
    }
}
