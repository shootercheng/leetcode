package com.scd.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author James
 */
public class Code20 {

    private static Map<Character, Character> BRACKET_MAP = new HashMap<>();

    static {
        BRACKET_MAP.put('(', ')');
        BRACKET_MAP.put('{', '}');
        BRACKET_MAP.put('[', ']');
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for (char c : charArr) {
            // 左边
            if (BRACKET_MAP.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character left = stack.pop();
                if (c != BRACKET_MAP.get(left)) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Code20 code20 = new Code20();
        System.out.println(code20.isValid("()"));
        System.out.println(code20.isValid(")("));
        System.out.println(code20.isValid("()[]{}"));
        System.out.println(code20.isValid("[()]{}"));
    }
}
