package com.scd.exercise.m10;

import java.util.regex.Pattern;

/**
 * @author James
 */
public class CodeOffer19 {

    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile(p);
        return pattern.matcher(s).matches();
    }
}
