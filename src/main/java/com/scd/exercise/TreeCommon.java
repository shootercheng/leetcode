
package com.scd.exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class TreeCommon {

    public static TreeNode createTree(List<Integer> list) {
        TreeNode root = new TreeNode(list.get(0));
        int i = 0;
        int len = list.size();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (i+2 < len) {
            TreeNode node = queue.poll();
            node.left = new TreeNode(list.get(i+1));
            node.right = new TreeNode(list.get(i+2));
            queue.offer(node.left);
            queue.offer(node.right);
            i = i + 2;
        }
        if (i+1 < len) {
            TreeNode node = queue.poll();
            node.left = new TreeNode(list.get(i+1));
        }
        return root;
    }

    public static TreeNode createNullEleTree(List<Integer> nums) {
        int len = nums.size();
        if (len == 0) {
            return new TreeNode(0);
        }
        TreeNode root = new TreeNode(nums.get(0));
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        int lenn = nums.size();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = null;
            if (i >= lenn) {
                break;
            }
            if (nums.get(i) != null) {
                left = new TreeNode(nums.get(i));
                node.left = left;
            }
            i++;
            if (i >= lenn) {
                break;
            }
            TreeNode right = null;
            if (nums.get(i) != null) {
                right = new TreeNode(nums.get(i));
                node.right = right;
            }
            i++;
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
        }
        return root;
    }


    public static TreeNode createBinaryTree(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return new TreeNode();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(list.get(0));
        queue.offer(root);
        int size = list.size();
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i < size) {
                Integer left = list.get(i);
                if (left == null) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(left);
                    queue.offer(node.left);
                }
                i++;
            } else {
                break;
            }
            if (i < size) {
                Integer right = list.get(i);
                if (right == null) {
                    node.right = null;
                } else {
                    node.right = new TreeNode(right);
                    queue.offer(node.right);
                }
                i++;
            } else {
                break;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        TreeNode root = createTree(list);
        System.out.println(root);
        List<Integer> nullEleList = Arrays.asList(1, null,2, null, 3, 4);
        TreeNode nullEleTree = createNullEleTree(nullEleList);
        System.out.println(nullEleTree);
        TreeNode treeNode = createBinaryTree(list);
        System.out.println(treeNode);
    }
}
