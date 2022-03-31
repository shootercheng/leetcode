package com.scd.exercise.m11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code925 {

    public boolean isLongPressedName(String name, String typed) {
        List<String> nameList = countStr(name);
        List<String> typedList = countStr(typed);
        if (nameList.size() != typedList.size()) {
            return false;
        }
        int size = nameList.size();
        for (int i = 0; i < size; i++) {
            String nameCharCount = nameList.get(i);
            String typeCharCount = typedList.get(i);
            String[] nameArr = nameCharCount.split("_");
            String[] typeArr = typeCharCount.split("_");
            if (!nameArr[0].equals(typeArr[0])) {
                return false;
            }
            if (Integer.parseInt(nameArr[1]) > Integer.parseInt(typeArr[1])) {
                return false;
            }
        }
        return true;
    }

    private List<String> countStr(String inputStr) {
        char[] inputArr = inputStr.toCharArray();
        List<String> list = new ArrayList<>();
        char temp = inputArr[0];
        int leni = inputArr.length;
        int count = 1;
        for (int i = 1; i < leni; i++) {
            if (inputArr[i] == temp) {
                count++;
            } else {
                list.add(temp + "_" + count);
                temp = inputArr[i];
                count = 1;
            }
        }
        list.add(temp + "_" + count);
        return list;
    }

    public static void main(String[] args) {
        Code925 code925 = new Code925();
//        System.out.println(code925.isLongPressedName("alex","aaleex"));
//        System.out.println(code925.isLongPressedName("leelee","lleeelee"));
//        System.out.println(code925.isLongPressedName("saeed","ssaaedd"));
//        "laidez"
//        "laideccc"
        System.out.println(code925.isLongPressedName("a","aaaaaaaaaaaaaaaaaa"));
    }
}
