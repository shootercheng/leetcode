package com.scd.exercise.y2022.m1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code1629 {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] charArr = keysPressed.toCharArray();
        Map<Integer, List<Character>> timeCharMap = new HashMap<>();
        int maxTime = releaseTimes[0];
        List<Character> charList = new ArrayList<>();
        charList.add(charArr[0]);
        timeCharMap.put(releaseTimes[0], charList);
        for (int i = 1; i < releaseTimes.length; i++) {
            int timeKey = releaseTimes[i] - releaseTimes[i - 1];
            if (timeKey > maxTime) {
                maxTime = timeKey;
            }
            List<Character> curCharList = timeCharMap.computeIfAbsent(timeKey, k -> new ArrayList<>());
            curCharList.add(charArr[i]);
        }
        List<Character> resultList = timeCharMap.get(maxTime).stream().sorted().collect(Collectors.toList());
        return resultList.get(resultList.size() - 1);
    }

    public static void main(String[] args) {
        Code1629 code1629 = new Code1629();
//        [12,23,36,46,62]
//        "spuda"
        code1629.slowestKey(new int[]{12,23,36,46,62}, "spuda");
    }
}
