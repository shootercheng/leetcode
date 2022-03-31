package com.scd.exercise.y2022.m3;

/**
 * 2124. 检查是否所有 A 都在 B 之前
 * @author James
 */
public class Code2124 {

    public boolean checkString(String s) {
        int lens = s.length();
        for (int i = 0; i < lens; i++) {
            if (s.charAt(i) == 'b') {
                String rightStr = s.substring(i+1);
                if (rightStr.contains("a")) {
                    return false;
                }
            }
        }
        return true;
    }
}
