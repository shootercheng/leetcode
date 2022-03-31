package com.scd.book.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class ExValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> dataMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!isValid("row" + i,  board[i][j], dataMap)) {
                    return false;
                }
                if (!isValid("col" + j,  board[i][j], dataMap)) {
                    return false;
                }
                if (i < 3) {
                    if (j < 3) {
                        if (!isValid("region" + 1, board[i][j], dataMap)) {
                            return false;
                        }
                    } else if (j < 6) {
                        if (!isValid("region" + 2, board[i][j], dataMap)) {
                            return false;
                        }
                    } else {
                        if (!isValid("region" + 3, board[i][j], dataMap)) {
                            return false;
                        }
                    }
                } else if (i < 6) {
                    if (j < 3) {
                        if (!isValid("region" + 4, board[i][j], dataMap)) {
                            return false;
                        }
                    } else if (j < 6) {
                        if (!isValid("region" + 5, board[i][j], dataMap)) {
                            return false;
                        }
                    } else {
                        if (!isValid("region" + 6, board[i][j], dataMap)) {
                            return false;
                        }
                    }
                } else {
                    if (j < 3) {
                        if (!isValid("region" + 7, board[i][j], dataMap)) {
                            return false;
                        }
                    } else if (j < 6) {
                        if (!isValid("region" + 8, board[i][j], dataMap)) {
                            return false;
                        }
                    } else {
                        if (!isValid("region" + 9, board[i][j], dataMap)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(String key, char ch, Map<String, Set<Character>> dataMap) {
        if (ch == '.') {
            return true;
        }
        Set<Character> data = dataMap.computeIfAbsent(key, k -> new HashSet<>());
        if (!data.contains(ch)) {
            data.add(ch);
        } else {
            return false;
        }
        return true;
    }
}
