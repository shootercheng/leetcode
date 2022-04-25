package com.scd.exercise.y2022.m4.easy;

/**
 * 2047 句子中的有效单词数
 * @author James
 */
public class Code2047 {

    private static final int ZERO = (int) '0';

    private static final int NINE = (int) '9';

    public int countValidWords(String sentence) {
        int count = 0;
        String[] senArr = sentence.split("\\s+");
        for (String word : senArr) {
            if (word.length() == 0) {
                continue;
            }
            if (isRightData(word)) {
                count++;
            }
        }
        return count;
    }

    private boolean isRightData(String word) {
        char[] wCharArr = word.toCharArray();
        int lenw = wCharArr.length;
        int countLine = 0;
        int countSymbol = 0;
        for (int i = 0; i < lenw; i++) {
            int iwChar = (int) wCharArr[i];
            if (iwChar >= ZERO && iwChar <= NINE) {
                return false;
            }
            if (wCharArr[i] == '-') {
                if (i == 0 || i == lenw - 1) {
                    return false;
                }
                if (!Character.isLowerCase(wCharArr[i - 1]) || !Character.isLowerCase(wCharArr[i+1])) {
                    return false;
                }
                countLine++;
            }
            if (countLine > 1) {
                return false;
            }
            if (isSymbol(wCharArr[i])) {
                if (i != lenw - 1) {
                    return false;
                }
                countSymbol++;
            }
            if (countSymbol > 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isSymbol(char inputChar) {
        return inputChar == '!' || inputChar == '.' || inputChar == ',';
    }

    public static void main(String[] args) {
        String s = " o6 t";
        Code2047 code2047 = new Code2047();
        code2047.countValidWords(s);
    }
}
