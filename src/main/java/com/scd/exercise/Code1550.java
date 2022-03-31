package com.scd.exercise;

/**
 * @author James
 */
public class Code1550 {

    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                if (++count >= 3) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,34,3,4,5,7,23,12};
        Code1550 code1550 = new Code1550();
        System.out.println(code1550.threeConsecutiveOdds(arr));
    }
}
