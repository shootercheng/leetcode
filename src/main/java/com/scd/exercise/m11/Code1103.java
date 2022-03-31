package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code1103 {

    public int[] distributeCandies(int candies, int num_people) {
        int[] candiesNumArr = new int[num_people];
        int sum = 0;
        int start = 1;
        int lastIndex = -1;
        out_while:
            while (true) {
                for (int i = 0; i < num_people; i++) {
                    sum = sum + start;
                    if (sum > candies) {
                        lastIndex = i;
                        break out_while;
                    }
                    candiesNumArr[i] = candiesNumArr[i] + start;
                    start++;
                }
            }
            int left = candies - sum + start;
            if (left > 0) {
                candiesNumArr[lastIndex] = candiesNumArr[lastIndex] + left;
            }
        return candiesNumArr;
    }

    public static void main(String[] args) {
        Code1103 code1103 = new Code1103();
        System.out.println(code1103.distributeCandies(7, 4));
        System.out.println(code1103.distributeCandies(10, 3));
    }
}
