package com.scd.exercise;

import java.util.regex.Pattern;

/**
 * @author James
 */
public class Code10 {

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        Pattern pattern = Pattern.compile(p);
        if (pattern.matcher(s).matches()) {
            System.out.println("ok");
        } else {
            System.out.println("no");
        }
    }
}
