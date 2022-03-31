package com.scd.exercise.y2021.m1;

/**
 * @author James
 */
public class Code696 {

    public int countBinarySubstrings(String s) {
        int lens = s.length();
        char[] scharArr = s.toCharArray();
        char temp = scharArr[0];
        int startIndex = 1;
        int moveIndex = 0;
        int count = 1;
        int result = 0;
//        StringBuilder subBuilder = new StringBuilder();
//        subBuilder.append(temp);
        while (moveIndex < lens) {
            if (startIndex == lens) {
                moveIndex++;
//                subBuilder.setLength(0);
                if (moveIndex >= lens - 1) {
                    break;
                }
                temp = scharArr[moveIndex];
//                subBuilder.append(temp);
                startIndex = moveIndex + 1;
                count = 1;
            }
            char curChar = scharArr[startIndex];
//            subBuilder.append(curChar);
            if (curChar == temp) {
                count++;
            } else {
                count--;
                if (count == 0) {
//                    System.out.println(subBuilder.toString());
//                    subBuilder.setLength(0);
                    result++;
                    moveIndex++;
                    temp = scharArr[moveIndex];
//                    subBuilder.append(temp);
                    startIndex = moveIndex;
                    count = 1;
                }
            }
            startIndex++;
        }
        return result;
    }

    public static void main(String[] args) {
        Code696 code696 = new Code696();
        System.out.println(code696.countBinarySubstrings("10101"));
    }
}
