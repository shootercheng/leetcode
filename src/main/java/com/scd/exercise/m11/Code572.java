package com.scd.exercise.m11;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author James
 */
public class Code572 {

    public boolean isSubtree(TreeNode s, TreeNode t) {
//        Map<Integer, List<Integer>> streeMap = new HashMap<>();
//        Map<Integer, List<Integer>> ttreeMap = new HashMap<>();
        getTreeMap(s);
        return false;
    }

    private List<Map<Integer, List<Integer>>> getTreeMap(TreeNode root) {
        List<Map<Integer, List<Integer>>> allTreeList = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left == null && node.right == null) {

            }
        }
//        Map<Integer, List<Integer>> oneTree = new HashMap<>();
//        List<Integer> subValueList = new ArrayList<>();
//        oneTree.put(node.val, subValueList);
        return allTreeList;
    }
}
