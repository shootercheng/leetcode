package com.scd.exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class CodeOffer32_1 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            values.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        int size = values.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = values.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
