package com.scd.exercise;

/**
 * @author James
 */
public class Code326 {
    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 3) {
            return false;
        }
        int m = n;
        while (true) {
            int mod = m % 3;
            if (mod != 0) {
                return false;
            }
            m = m / 3;
            if (m < 3) {
                break;
            }
        }
        if (m != 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Code326 code326 = new Code326();
        System.out.println(code326.isPowerOfThree(1));
        System.out.println(code326.isPowerOfThree(2));
        System.out.println(code326.isPowerOfThree(3));
        System.out.println(code326.isPowerOfThree(27));
        System.out.println(code326.isPowerOfThree(9));
    }
}
