package com.scd.exercise.y2021.m7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code36 {

    public boolean isValidSudoku(char[][] board) {
        int lenb = board.length;
        Map<String, Set<Character>> regionMap = new HashMap<>(11);
        for (int i = 0; i < lenb; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char curChar = board[i][j];
                String rowKey = "row" + i;
                if (!isValid(rowKey, curChar, regionMap)) {
                    return false;
                }
                String colKey = "col" + j;
                if (!isValid(colKey, curChar, regionMap)) {
                    return false;
                }
                if (i <= 2) {
                    if (j <= 2) {
                        if (!isValid("1", curChar, regionMap)) {
                            return false;
                        }
                    } else if (j <= 5) {
                        if (!isValid("2", curChar, regionMap)) {
                            return false;
                        }
                    } else {
                        if (!isValid("3", curChar, regionMap)) {
                            return false;
                        }
                    }
                } else if (i <= 5) {
                    if (j <= 2) {
                        if (!isValid("4", curChar, regionMap)) {
                            return false;
                        }
                    } else if (j <= 5) {
                        if (!isValid("5", curChar, regionMap)) {
                            return false;
                        }
                    } else {
                        if (!isValid("6", curChar, regionMap)) {
                            return false;
                        }
                    }
                } else {
                    if (j <= 2) {
                        if (!isValid("7", curChar, regionMap)) {
                            return false;
                        }
                    } else if (j <= 5) {
                        if (!isValid("8", curChar, regionMap)) {
                            return false;
                        }
                    } else {
                        if (!isValid("9", curChar, regionMap)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(String key, char ch, Map<String, Set<Character>> regionMap) {
        if (ch == '.') {
            return true;
        }
        Set<Character> set = regionMap.computeIfAbsent(key, k -> new HashSet<>());
        if (!set.contains(ch)) {
            set.add(ch);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Code36 code36 = new Code36();
        char[][] borad = new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(code36.isValidSudoku(borad));
    }
}
