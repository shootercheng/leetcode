package com.scd.exercise.m12;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author James
 */
public class Code146 {

    static class LRUCache {

        private Map<Integer, Integer> linkMap = new LinkedHashMap<>();

        private Queue<Integer> keyQueue = new ArrayDeque<>();

        private int capacity;

        private int curSize = 0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer val = linkMap.get(key);
            if (val == null) {
                return -1;
            }
            linkMap.remove(key);
            keyQueue.remove(key);
            linkMap.put(key, val);
            keyQueue.offer(key);
            return val;
        }

        public void put(int key, int value) {
            if (linkMap.containsKey(key)) {
                keyQueue.remove(key);
                keyQueue.offer(key);
                linkMap.put(key, value);
            } else {
                // 移除第一个元素
                if (curSize == capacity) {
                    Integer curKey = keyQueue.poll();
                    linkMap.remove(curKey);
                    curSize--;
                }
                linkMap.put(key, value);
                keyQueue.offer(key);
                curSize++;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3,3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4,4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4
    }
}
