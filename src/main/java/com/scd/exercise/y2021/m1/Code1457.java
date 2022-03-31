package com.scd.exercise.y2021.m1;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author James
 */
public class Code1457 {

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] result = new int[1];
        List<Integer> onePath = new ArrayList<>();
        traverseConuntPalindrom(root, onePath, result);
        return result[0];
    }

    private void traverseConuntPalindrom(TreeNode root, List<Integer> onePath, int[] result) {
        if (root != null) {
            onePath.add(root.val);
            if (root.left == null && root.right == null) {
                if (isConstructPalindrom(onePath)) {
                    result[0]++;
                }
            }
            traverseConuntPalindrom(root.left, new ArrayList<>(onePath), result);
            traverseConuntPalindrom(root.right, new ArrayList<>(onePath), result);
        }
    }

    private boolean isConstructPalindrom(List<Integer> onePath) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (Integer nodeVal : onePath) {
            Integer count = countMap.computeIfAbsent(nodeVal, k -> 0);
            countMap.put(nodeVal, ++count);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = countMap.entrySet();
        int oddNum = 0;
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            int count = entry.getValue();
            if (count % 2 != 0) {
                oddNum++;
            }
        }
        return oddNum <= 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeCommon.createBinaryTree(Arrays.asList(2,3,1,3,1,null,1));
        Code1457 code1457 = new Code1457();
        System.out.println(code1457.pseudoPalindromicPaths(treeNode));
    }
}
