package com.scd.exercise;

/**
 * @author James
 */
public class Code1528 {

    public String restoreString(String s, int[] indices) {
        char[] scharArr = s.toCharArray();
        int len = indices.length;
        char[] result = new char[len];
        for (int i = 0; i < len; i++) {
            result[indices[i]] = scharArr[i];
        }
        return new String(result);
    }
}
