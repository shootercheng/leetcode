package com.scd.exercise.m12;

import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author James
 */
public class Code653 {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> dataList = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        traverseTree(root, dataList, countMap);
        for (Integer ele : dataList) {
            int other = k - ele;
            if (ele == other) {
                if (countMap.get(ele) == 2) {
                    return true;
                }
            } else {
                if (countMap.containsKey(other)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void traverseTree(TreeNode root, List<Integer> dataList, Map<Integer, Integer> countMap) {
        if (root != null) {
            dataList.add(root.val);
            Integer count = countMap.computeIfAbsent(root.val, k -> 0);
            countMap.put(root.val, ++count);
            traverseTree(root.left, dataList, countMap);
            traverseTree(root.right, dataList, countMap);
        }
    }
}
