package com.scd.exercise;

/**
 * @author James
 */
public class Code657 {

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        char[] moveCharArr = moves.toCharArray();
        for (char c : moveCharArr) {
            if (c == 'L') {
                x--;
            } else if (c == 'R') {
                x++;
            } else if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            }
        }
        return x == 0 && y == 0;
    }
}
