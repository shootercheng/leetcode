package com.scd.exercise.y2022.m3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2194. Excel 表中某个范围内的单元格
 * @author James
 */
public class Code2194 {

    public List<String> cellsInRange(String s) {
        String[] sArr = s.split(":");
        Arrays.sort(sArr);
        char start = sArr[0].charAt(0);
        int rowStart = Integer.parseInt(sArr[0].substring(1));
        char end = sArr[1].charAt(0);
        int rowEnd = Integer.parseInt(sArr[1].substring(1));
        List<String> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            for (int j = rowStart; j <= rowEnd; j++) {
                String curStr = (char) i + "" + j;
                result.add(curStr);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "A1:F1";
        Code2194 code2194 = new Code2194();
        code2194.cellsInRange(s);
    }
}
