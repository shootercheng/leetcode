package com.scd.exercise.m11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code744 {


    public char nextGreatestLetter(char[] letters, char target) {
        char result = 'a';
        char revserResult = 'a';
        boolean isFind = false;
        Integer min = 26;
        Integer max = 0;
        for (char c : letters) {
            if (c == target) {
                continue;
            }
            // 正向距离
            int dis = c - target;
            if (dis > 0 && dis < min) {
                min = dis;
                result = c;
                isFind = true;
            }
            if (!isFind) {
                // 反向距离
                int reverseDis = target - c;
                if (reverseDis > 0 && reverseDis > max) {
                    max = reverseDis;
                    revserResult = c;
                }
            }
        }
        if (isFind) {
            return result;
        }
        return revserResult;
    }

    public static void main(String[] args) {
        Code744 code744 = new Code744();
        char[] input = {'c','f','j'};
        code744.nextGreatestLetter(input, 'j');
    }
}
