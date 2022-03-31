package com.scd.exercise.m10;

import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class CodeOffer54 {

    public int kthLargest(TreeNode root, int k) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        List<Integer> dataList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            dataList.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        dataList = dataList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        if (k <= dataList.size()) {
            return dataList.get(k - 1);
        }
        return Integer.MIN_VALUE;
    }
}
