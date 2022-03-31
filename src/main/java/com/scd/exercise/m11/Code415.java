package com.scd.exercise.m11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author James
 */
public class Code415 {

    public String addStrings(String num1, String num2) {
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();
        Map<Integer, Integer> indexNum1Map = getIndexMap(num1Arr);
        Map<Integer, Integer> indexNum2Map = getIndexMap(num2Arr);
        if (indexNum1Map.size() >= indexNum2Map.size()) {
            return addTwoMap(indexNum1Map, indexNum2Map);
        } else {
            return addTwoMap(indexNum2Map, indexNum1Map);
        }
    }

    private String addTwoMap(Map<Integer, Integer> indexNum1Map, Map<Integer, Integer> indexNum2Map) {
        int minSize = indexNum2Map.size();
        for (int i = 0; i < minSize; i++) {
            int num1 = indexNum1Map.get(i);
            int num2 = indexNum2Map.get(i);
            int sum = num1 + num2;
            if (sum >= 10) {
                int maxIndexNum = sum - 10;
                indexNum1Map.put(i, maxIndexNum);
                Integer val = indexNum1Map.get(i+1);
                if (val != null) {
                    addPreviousNum(i+1, indexNum1Map);
                } else {
                    indexNum1Map.put(i+1, 1);
                }
            } else {
                indexNum1Map.put(i, sum);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = indexNum1Map.size() - 1; i >= 0; i--) {
            result.append(indexNum1Map.get(i));
        }
        return result.toString();
    }

    private void addPreviousNum(int startIndex, Map<Integer, Integer> indexNum1Map) {
        while (true) {
            int startNum = indexNum1Map.get(startIndex);
            if (startNum == 9) {
                indexNum1Map.put(startIndex, 0);
                Integer val = indexNum1Map.get(startIndex + 1);
                if (val != null) {
                    startIndex = startIndex +1;
                } else {
                    indexNum1Map.put(startIndex + 1, 1);
                    break;
                }
            } else {
                indexNum1Map.put(startIndex, startNum + 1);
                break;
            }
        }
    }

    private Map<Integer, Integer> getIndexMap(char[] numArr) {
        int len = numArr.length;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = len - 1; i >= 0; i--) {
            int num = numArr[i] - '0';
            map.put(j++, num);
        }
        return map;
    }

    public static void main(String[] args) {
        Code415 code415 = new Code415();
        System.out.println(code415.addStrings("2", "99999"));
    }
}
