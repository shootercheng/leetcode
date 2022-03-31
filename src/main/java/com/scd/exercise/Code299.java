package com.scd.exercise;

/**
 * @author James
 */
public class Code299 {

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        char[] scharArr = secret.toCharArray();
        char[] gcharArr = guess.toCharArray();
        int len = secret.length();
        boolean[] secretfinds = new boolean[len];
        boolean[] guessFinds = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (scharArr[i] == gcharArr[i]) {
                bulls++;
                secretfinds[i] = true;
                guessFinds[i] = true;
            }
        }
        for (int i = 0; i < len; i++) {
            if (!secretfinds[i]) {
                for (int j = 0; j < len; j++) {
                    if (scharArr[i] == gcharArr[j] && !guessFinds[j]) {
                        guessFinds[j] = true;
                        if (i != j) {
                            cows++;
                            secretfinds[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(bulls).append("A").append(cows).append("B");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

    }
}
