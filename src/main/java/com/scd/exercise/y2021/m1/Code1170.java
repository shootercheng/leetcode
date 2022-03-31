package com.scd.exercise.y2021.m1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        List<Integer> qList = countArr(queries);
        List<Integer> wList = countArr(words);
        List<Integer> result = new ArrayList<>();
        for (Integer q : qList) {
            int count = 0;
            for (Integer w : wList) {
                if (q < w) {
                    count++;
                }
            }
            result.add(count);
        }
        int rSize = result.size();
        int[] rIntRes = new int[rSize];
        for (int i = 0; i < rSize; i++) {
            rIntRes[i] = result.get(i);
        }
        return rIntRes;
    }

    public List<Integer> countArr(String[] inputArr) {
        List<Integer> countList = new ArrayList<>();
        for (String input : inputArr) {
            countList.add(countStrNum(input));
        }
        return countList;
    }

    public int countStrNum(String input) {
        char[] inputArr = input.toCharArray();
        Arrays.sort(inputArr);
        int leni = inputArr.length;
        char temp = inputArr[0];
        int count = 1;
        for (int i = 1; i < leni; i++) {
            if (inputArr[i] == temp) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Code1170 code1170 = new Code1170();
        System.out.println(code1170.countStrNum("aaaaaa"));
    }
}
