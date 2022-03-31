package com.scd.exercise;

/**
 * @author James
 */
public class Code1010 {

    public int numPairsDivisibleBy60(int[] time) {
        int len = time.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 10;
        int mod = num % 60;
        System.out.println(mod);
        int[] time = {30,20,150,100,40};
        Code1010 code1010 = new Code1010();
        code1010.numPairsDivisibleBy60(time);
    }
}
