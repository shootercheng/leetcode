package com.scd.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class Code500 {

    private static final Set<Character> FIRST_ROW = new HashSet<>();

    static {
        FIRST_ROW.add('Q');
        FIRST_ROW.add('W');
        FIRST_ROW.add('E');
        FIRST_ROW.add('R');
        FIRST_ROW.add('T');
        FIRST_ROW.add('Y');
        FIRST_ROW.add('U');
        FIRST_ROW.add('I');
        FIRST_ROW.add('O');
        FIRST_ROW.add('P');
    }

    private static final Set<Character> SECOND_ROW = new HashSet<>();

    static {
        SECOND_ROW.add('A');
        SECOND_ROW.add('S');
        SECOND_ROW.add('D');
        SECOND_ROW.add('F');
        SECOND_ROW.add('G');
        SECOND_ROW.add('H');
        SECOND_ROW.add('J');
        SECOND_ROW.add('K');
        SECOND_ROW.add('L');
    }

    private static final Set<Character> THRID_ROW = new HashSet<>();

    static {
        THRID_ROW.add('Z');
        THRID_ROW.add('X');
        THRID_ROW.add('C');
        THRID_ROW.add('V');
        THRID_ROW.add('B');
        THRID_ROW.add('N');
        THRID_ROW.add('M');
    }

    public String[] findWords(String[] words) {
        List<String> stringList = new ArrayList<>();
        for (String word : words) {
            char[] charArr = word.toCharArray();
            int lenc = charArr.length;
            char c = charArr[0];
            char upper = toUpper(c);
            Set<Character> rowCharacter = findRow(upper);
            boolean isAllContain = true;
            for (int i = 1; i < lenc; i++) {
                if (!rowCharacter.contains(toUpper(charArr[i]))) {
                    isAllContain = false;
                    break;
                }
            }
            if (isAllContain) {
                stringList.add(word);
            }
        }
        String[] result = new String[stringList.size()];
        stringList.toArray(result);
        return result;
    }

    private char toUpper(char c) {
        char upper;
        if (c >= 'a' && c <= 'z') {
            upper = Character.toUpperCase(c);
        } else {
            upper = c;
        }
        return upper;
    }

    public Set<Character> findRow(char c) {
        if (FIRST_ROW.contains(c)) {
            return FIRST_ROW;
        } else if (SECOND_ROW.contains(c)) {
            return SECOND_ROW;
        } else if (THRID_ROW.contains(c)) {
            return THRID_ROW;
        } else {
            return new HashSet<>();
        }
    }

    public static void main(String[] args) {
        String[] words = {"asdfghjkl","qwertyuiop","zxcvbnm"};
        Code500 code500 = new Code500();
        String[] result = code500.findWords(words);
        System.out.println(result);
    }
}
