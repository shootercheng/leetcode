package com.scd.exercise.y2021.m7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class Code93 {

    public List<String> restoreIpAddresses(String s) {
        int lens = s.length();
        if (lens < 4 || lens > 12) {
            return new ArrayList<>();
        }
        Set<String> resultSet = new HashSet<>();
        for (int i = 1; i < 4 && i < lens; i++) {
            String subOneStr = s.substring(0, i);
//            System.out.println(subStr);
            if (isContinue(subOneStr)) {
                continue;
            }
            if (isBreak(subOneStr)) {
                break;
            }
            for (int j = i + 1; j < i + 4 && j < lens; j++) {
                String subTwoStr = s.substring(i, j);
//                System.out.println(subTwoStr);
                int subTwoInt = Integer.parseInt(subTwoStr);
                if (isContinue(subTwoStr)) {
                    continue;
                }
                if (isBreak(subTwoStr)) {
                    break;
                }
                for (int k = j+1; k < j+4 && k < lens; k++) {
                    String subThreeStr = s.substring(j, k);
//                    System.out.println(subThreeStr);
                    if (isContinue(subThreeStr)) {
                        continue;
                    }
                    if (isBreak(subThreeStr)) {
                        break;
                    }
                    for (int l = k+1; l < k+4 && l <= lens; l++) {
                        String subFourStr = s.substring(k, lens);
//                        System.out.println(subFourStr);
                        if (isContinue(subFourStr)) {
                            continue;
                        }
                        if (isBreak(subFourStr)) {
                            break;
                        }
                        String ip = subOneStr + "." + subTwoStr + "." + subThreeStr + "." + subFourStr;
                        resultSet.add(ip);
                    }
                }
            }
        }
        return new ArrayList<>(resultSet);
    }

    private boolean isContinue(String subStr) {
       return subStr.startsWith("0") && subStr.length() > 1;
    }

    private boolean isBreak(String subStr) {
        if (subStr.length() > 3) {
            return true;
        }
        return Integer.parseInt(subStr) > 255;
    }

    public static void main(String[] args) {
        Code93 code93 = new Code93();
        System.out.println(code93.restoreIpAddresses("0279245587303"));
    }
}
