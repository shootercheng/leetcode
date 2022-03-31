package com.scd.exercise.y2021.m7;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class Code114 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return ;
        }
        List<Integer> list = new ArrayList<>();
        preTraverseTree(root, list);
        TreeNode result = createNullEleTree(list);
        root.right = result.right;
        root.left = null;
    }

    public TreeNode createNullEleTree(List<Integer> nums) {
        int len = nums.size();
        if (len == 0) {
            return new TreeNode(0);
        }
        TreeNode root = new TreeNode(nums.get(0));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        int lenn = nums.size();
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            TreeNode node = queue.poll();
            TreeNode left = null;
            if (i >= lenn) {
                break;
            }
            if (nums.get(i) != null) {
                left = new TreeNode(nums.get(i));
            }
            i++;
            if (i >= lenn) {
                break;
            }
            TreeNode right = null;
            if (nums.get(i) != null) {
                right = new TreeNode(nums.get(i));
            }
            i++;
            node.left = left;
            node.right = right;
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
        }
        return root;
    }

    public void preTraverseTree(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            list.add(treeNode.val);
            list.add(null);
            preTraverseTree(treeNode.left, list);
            preTraverseTree(treeNode.right, list);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,5,3,4,null,6);
        TreeNode treeNode = TreeCommon.createNullEleTree(list);
        System.out.println(treeNode);
        Code114 code114 = new Code114();
        code114.flatten(treeNode);
    }
}
