package com.scd.exercise.m10;

import java.util.Stack;

/**
 * @author James
 */
public class Code394 {

    public String decodeString(String s) {
        char[] sArr = s.toCharArray();
        Stack<Character> charStack = new Stack<>();
        for (char c : sArr) {
            if (c == '[' || Character.isLetter(c) || Character.isDigit(c)) {
                charStack.push(c);
            } else if (c == ']') {
                StringBuilder stringBuilder = new StringBuilder();
                char curChar;
                StringBuilder element = new StringBuilder();
                while ((curChar = charStack.pop()) != '[') {
                    element.append(curChar);
                }
                element = element.reverse();
                StringBuilder num = new StringBuilder();
                while (!charStack.isEmpty() && Character.isDigit(charStack.peek())) {
                    num.append(charStack.pop());
                }
                int loopNum = Integer.parseInt(num.reverse().toString());
                for (int i = 0; i < loopNum; i++) {
                    stringBuilder.append(element);
                }
                int slen = stringBuilder.length();
                for (int i = 0; i < slen; i++) {
                    charStack.push(stringBuilder.charAt(i));
                }
            }
        }
        StringBuilder last = new StringBuilder();
        while (!charStack.isEmpty()) {
            last.append(charStack.pop());
        }
        return last.reverse().toString();
    }

    public static void main(String[] args) {
        Code394 code394 = new Code394();
//        System.out.println(code394.decodeString("3[a]2[bc]"));
//        System.out.println(code394.decodeString("3[a2[c]]"));
//        System.out.println(code394.decodeString("2[abc]3[cd]e"));
//        System.out.println(code394.decodeString("100[lee]"));
        // "sdfeegfeegi"
        System.out.println(code394.decodeString("sd2[f2[e]g]i"));
    }
}
