package com.scd.contest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code5727_1 {

    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int[] result = new int[1];
        removeData(list, k, result);
        return result[0];
    }

    public void removeData(List<Integer> list, int k, int[] result) {
        if (list.size() == 1) {
            result[0] = list.get(0);
            return;
        }
        int removeIndex;
        if (list.size() >= k) {
            removeIndex = (k - 1) % list.size();
        } else {
            int index = 0;
            int count = 1;
            while (true) {
                index++;
                count++;
                if (count == k) {
                    removeIndex = index;
                    break;
                }
                if (index == list.size() - 1) {
                    index = 0;
                    count++;
                    if (count == k) {
                        removeIndex = index;
                        break;
                    }

                }
            }
        }
        list.remove(removeIndex);
        if (list.size() == 1) {
            result[0] = list.get(0);
            return;
        }
        List<Integer> newList = new ArrayList<>();
        for (int i = removeIndex; i < list.size(); i++) {
            newList.add(list.get(i));
        }
        for (int i = 0; i < removeIndex; i++) {
            newList.add(list.get(i));
        }
        removeData(newList, k, result);
    }

    public static void main(String[] args) {
        Code5727_1 code5727 = new Code5727_1();
//        System.out.println(code5727.findTheWinner(5, 2));
//        System.out.println(code5727.findTheWinner(6, 5));
//        System.out.println(code5727.findTheWinner(3, 1));
//        System.out.println(code5727.findTheWinner(5, 3));
//        System.out.println(code5727.findTheWinner(6, 5));
//        System.out.println(code5727.findTheWinner(3, 1));
        System.out.println(code5727.findTheWinner(5, 4));
    }
}
