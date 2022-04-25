package com.scd.exercise.y2022.m4.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380.O(1) 时间插入、删除和获取随机元素
 * @author James
 */
public class Code380 {

    class RandomizedSet {

        private Random random;

        private List<Integer> numList;

        private Map<Integer, Integer> numIndexMap;

        public RandomizedSet() {
            random = new Random();
            numList = new ArrayList<>();
            numIndexMap = new HashMap<>();
        }

        public boolean insert(int val) {
            if (numIndexMap.containsKey(val)) {
                return false;
            }
            int index = numList.size();
            numIndexMap.put(val, index);
            numList.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (numIndexMap.containsKey(val)) {
                int index = numIndexMap.get(val);
                int lastIndex = numList.size() - 1;
                int lastNum = numList.get(lastIndex);
                numList.set(index, lastNum);
                numIndexMap.put(lastNum, index);
                numList.remove(lastIndex);
                numIndexMap.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            int index = random.nextInt(numList.size());
            return numList.get(index);
        }
    }
}
