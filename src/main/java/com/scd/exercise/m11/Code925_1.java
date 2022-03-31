package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code925_1 {

    public boolean isLongPressedName(String name, String typed) {
        char[] nameArr = name.toCharArray();
        char[] typedArr = typed.toCharArray();
        int lenn = nameArr.length;
        int lent = typedArr.length;
        int npoint = 0;
        int tpoint = 0;
        char[] nresult = new char[1];
        int[] ncount = new int[1];
        char[] tresult = new char[1];
        int[] tcount = new int[1];
        while (true) {
            npoint = findNext(nameArr, lenn, npoint, nresult, ncount);
            tpoint = findNext(typedArr, lent, tpoint, tresult, tcount);
            if (nresult[0] != tresult[0]) {
                return false;
            }
            if (ncount[0] > tcount[0]) {
                return false;
            }
            if (npoint == -1 && tpoint != -1) {
                return false;
            }
            if (npoint != -1 && tpoint == -1) {
                return false;
            }
            if (npoint == -1) {
                return true;
            }
        }
    }

    private int findNext(char[] nameArr, int lenn, int npoint, char[] nresult, int[] ncount) {
        if (npoint == lenn) {
            return -1;
        }
        char temp = nameArr[npoint];
        int count = 1;
        int index = -1;
        for (int i = npoint + 1; i < lenn; i++) {
            if (nameArr[i] == temp) {
                count++;
            } else {
                index = i;
                break;
            }
        }
        nresult[0] = temp;
        ncount[0] = count;
        return index;
    }

    public static void main(String[] args) {
        Code925_1 code952 = new Code925_1();
        System.out.println(code952.isLongPressedName("alex","aaleex"));
        System.out.println(code952.isLongPressedName("leelee","lleeelee"));
        System.out.println(code952.isLongPressedName("saeed","ssaaedd"));
//        "laidez"
//        "laideccc"
        System.out.println(code952.isLongPressedName("a","aaaaaaaaaaaaaaaaaa"));
    }
}
