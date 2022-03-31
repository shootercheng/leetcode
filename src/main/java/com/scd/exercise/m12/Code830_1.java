package com.scd.exercise.m12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code830_1 {

    class CharNum {
        private char c;

        private Integer num;

        public CharNum(char c, Integer num) {
            this.c = c;
            this.num = num;
        }
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        char[] sArr = s.toCharArray();
        List<CharNum> charList = new ArrayList<>();
        char temp = sArr[0];
        int count = 1;
        for (int i = 1; i < sArr.length; i++) {
            char c = sArr[i];
            if (c == temp) {
                count++;
            } else {
                CharNum charNum = new CharNum(temp, count);
                charList.add(charNum);
                count = 1;
                temp = c;
            }
        }
        CharNum charNum = new CharNum(temp, count);
        charList.add(charNum);
        int startIndex = 0;
        List<List<Integer>> resultList = new ArrayList<>();
        for (CharNum cn : charList) {
            if (cn.num >= 3) {
                List<Integer> oneRes = new ArrayList<>();
                oneRes.add(startIndex);
                oneRes.add(startIndex + cn.num - 1);
                resultList.add(oneRes);
            }
            startIndex = startIndex + cn.num;
        }
        return resultList;
    }

    public static void main(String[] args) {
        String str = "abcdddeeeeaabbbcd";
        Code830_1 code830 = new Code830_1();
        System.out.println(code830.largeGroupPositions(str));
        System.out.println(code830.largeGroupPositions("rrgrrrrraa"));
        System.out.println(code830.largeGroupPositions("nnnhaaannnm"));
    }
}
