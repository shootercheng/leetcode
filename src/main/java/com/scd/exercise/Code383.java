package com.scd.exercise;

/**
 * @author James
 */
public class Code383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransCharArr = ransomNote.toCharArray();
        boolean[] used = new boolean[magazine.length()];
        char[] magaArr = magazine.toCharArray();
        for (char c : ransCharArr) {
            if (!findIndex(magaArr, c, used)) {
                return false;
            }
        }
        return true;
    }

    private boolean findIndex(char[] magaArr, char c, boolean[] used) {
        int len = magaArr.length;
        for(int i = 0; i < len; i++) {
            if (magaArr[i] == c && !used[i]) {
                used[i] = true;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String rans = "aa";
        String maga = "ab";
        Code383 code383 = new Code383();
        System.out.println(code383.canConstruct(rans, maga));
    }
}
