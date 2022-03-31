package com.scd.exercise.m11;

/**
 * @author James
 */
public class Code605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        while (i < n) {
            int startIndex = findNext(flowerbed);
            if (startIndex == -1) {
                return false;
            }
            i++;
        }
        return true;
    }

    private int findNext(int[] flowerbed) {
        int index = -1;
        int size = flowerbed.length;
        if (size == 1 && flowerbed[0] == 0) {
            return 0;
        }
        for (int i = 0; i < size; i++) {
            // 第一个位置
            if (size > 1 && flowerbed[0] == 0 && flowerbed[1] == 0) {
                flowerbed[0] = 1;
                index = 0;
                break;
            } else if (size > 1 && flowerbed[size - 1] == 0 && flowerbed[size - 2] == 0) {
                // 最后一个位置
                flowerbed[size - 1] = 1;
                index = size - 1;
                break;
            } else {
                // 中间位置
                if (i > 0 && i < size - 1 && flowerbed[i] == 0
                        && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    index = i;
                    break;
                }
            }

        }
        return index;
    }

    public static void main(String[] args) {
        int[] flower = {0,0,0,0};
        Code605 code605 = new Code605();
        System.out.println(code605.canPlaceFlowers(flower, 3));
    }
}
