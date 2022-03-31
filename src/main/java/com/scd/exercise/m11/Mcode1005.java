package com.scd.exercise.m11;

/**
 * @author James
 */
public class Mcode1005 {

    public int findString(String[] words, String s) {
        int left = 0;
        int right = words.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            while ("".equals(words[mid])) {
                mid++;
            }
            if (words[mid].equals(s)) {
                return mid;
            } else {
                while ("".equals(words[left])) {
                    left++;
                }
                while ("".equals(words[right])) {
                    right--;
                }
                if (words[mid].compareTo(s) < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int binarySearch(int[] inputNum, int searchNum) {
        int left = 0;
        int right = inputNum.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (inputNum[mid] == searchNum) {
                return mid;
            } else if (inputNum[mid] < searchNum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("at".compareTo("ball"));
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""};
        Mcode1005 mcode1005 = new Mcode1005();
        mcode1005.findString(words, "ta");
        int[] inputNum = {1,3,5,7,9};
        System.out.println(mcode1005.binarySearch(inputNum, 1));
        System.out.println(mcode1005.binarySearch(inputNum, 9));
        System.out.println(mcode1005.binarySearch(inputNum, 3));
    }
}
