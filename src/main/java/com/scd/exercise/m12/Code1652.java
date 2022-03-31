package com.scd.exercise.m12;

/**
 * @author James
 */
public class Code1652 {

    public int[] decrypt(int[] code, int k) {
        int lenc = code.length;
        int[] result = new int[lenc];
        if (k == 0) {
            return result;
        }
        int startIndex = 0;
        int movePointer = startIndex;
        int count = 1;
        if (k > 0) {
            while (startIndex < lenc) {
                int sum = 0;
                while (count <= k) {
                    // 复位
                    if (movePointer == lenc - 1) {
                        movePointer = 0;
                    } else {
                        movePointer = movePointer + 1;
                    }
                    sum = sum + code[movePointer];
                    count++;
                }
                result[startIndex] = sum;
                count = 1;
                startIndex++;
                movePointer = startIndex;
            }
        } else {
            k = -k;
            while (startIndex < lenc) {
                int sum = 0;
                while (count <= k) {
                    // 复位
                    if (movePointer == 0) {
                        movePointer = lenc - 1;
                    } else {
                        movePointer = movePointer - 1;
                    }
                    sum = sum + code[movePointer];
                    count++;
                }
                result[startIndex] = sum;
                count = 1;
                startIndex++;
                movePointer = startIndex;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] code = {5,7,1,4};
        Code1652 code1652 = new Code1652();
//        System.out.println(code1652.decrypt(code, 3));
        System.out.println(code1652.decrypt(new int[]{2,4,9,3}, -2));
    }
}
