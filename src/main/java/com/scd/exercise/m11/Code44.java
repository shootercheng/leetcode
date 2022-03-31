package com.scd.exercise.m11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author James
 */
public class Code44 {

    private static final Pattern SYMBOL_PATTERN = Pattern.compile("\\*+");

    public boolean isMatch(String s, String p) {
        Matcher matcher = SYMBOL_PATTERN.matcher(p);
        if (matcher.find()) {
            p = matcher.replaceAll("*");
    }
        char[] pcharArr = p.toCharArray();
        StringBuilder pattern = new StringBuilder();
        for (char pchar : pcharArr) {
            if (pchar == '?') {
                pattern.append("[a-z]");
            } else if (pchar == '*') {
                pattern.append(".").append('*');
            } else {
                pattern.append(pchar);
            }
        }
        Pattern regexPattern = Pattern.compile(pattern.toString());
        return regexPattern.matcher(s).matches();
    }

    public static void main(String[] args) {
        String s = "acdcb";
        String p = "a*c?b";
        Code44 code44 = new Code44();
//        System.out.println(code44.isMatch(s, p));
//        "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba"
//        "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"
        System.out.println(code44.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
                "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*"));
    }
}
