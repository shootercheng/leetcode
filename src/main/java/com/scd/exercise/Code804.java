package com.scd.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code804 {

    private static final String[] MOL_CODE = {".-","-...","-.-.","-..",".","..-.","--.","....",
            "..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",
            ".--","-..-","-.--","--.."};

    private static Map<Character, String> MOL_MAP = new HashMap<>();

    static {
        for (int i = 0; i < 26; i++) {
            char c = (char) ((int) 'a' + i);
            MOL_MAP.put(c, MOL_CODE[i]);
        }
    }



    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            char[] wordArr = word.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : wordArr) {
                String str = MOL_MAP.get(c);
                stringBuilder.append(str);
            }
            set.add(stringBuilder.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        int a = 'a';
        for (int i = 0; i < 26; i++) {
            char c = (char) ((int) 'a' + i);
            System.out.println(c);
        }
//        System.out.println(a);
        Code804 code804 = new Code804();
        int result = code804.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"});
        System.out.println(result);
    }
}
