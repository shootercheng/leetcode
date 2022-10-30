package com.scd.exercise.y2022.m9.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 股票价格跨度
 */
public class Code901 {

    static class StockSpanner {
        private List<Integer> list;

        public StockSpanner() {
            list = new ArrayList<>();
        }

        public int next(int price) {
            list.add(price);
            int size = list.size();
            int maxCount = 0;
            int count = 0;
            for (int i = size - 1; i >= 0; i--) {
                if (list.get(i) <= price) {
                    count++;
                } else {
                    if (count > maxCount) {
                        maxCount = count;
                    }
                    count = 0;
                }
            }
            if (count > maxCount) {
                maxCount = count;
            }
            return maxCount;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(1, 2);
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(1));
        System.out.println(stockSpanner.next(3));
        System.out.println(stockSpanner.next(5));
        System.out.println(stockSpanner.next(2));
        System.out.println(list);
    }
}
