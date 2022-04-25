package com.scd.exercise.y2022.m4.hard;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer II 048. 序列化与反序列化二叉树
 * @author James
 */
public class CodeOffer048 {

    public static class Codec {

        private static final String NULL_ELE = "null";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            List<String> list = new ArrayList<>();
            list.add(root.val + "");
            while (!queue.isEmpty()) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                    list.add(curNode.left.val + "");
                } else {
                    list.add("null");

                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                    list.add(curNode.right.val + "");
                } else {
                    list.add("null");
                }
            }
            int endIndex = -1;
            for (int i = list.size() - 1; i >= 0; i--) {
                if (!NULL_ELE.equals(list.get(i))) {
                    endIndex = i;
                    break;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i <= endIndex; i++) {
                stringBuilder.append(list.get(i));
                if (i != endIndex) {
                    stringBuilder.append(",");
                }
            }
            return stringBuilder.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }
            String[] strArr = data.split(",");
            int lens = strArr.length;
            Queue<TreeNode> queue = new ArrayDeque<>();
            int index = 0;
            TreeNode root = new TreeNode(Integer.parseInt(strArr[0]));
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode curNode = queue.poll();
                index++;
                if (index >= lens) {
                    break;
                }
                if (!NULL_ELE.equals(strArr[index])) {
                    TreeNode treeNode = new TreeNode(Integer.parseInt(strArr[index]));
                    curNode.left = treeNode;
                    queue.offer(treeNode);
                } else {
                    curNode.left = null;
                }
                index++;
                if (index >= lens) {
                    break;
                }
                if (!NULL_ELE.equals(strArr[index])) {
                    TreeNode treeNode = new TreeNode(Integer.parseInt(strArr[index]));
                    curNode.right = treeNode;
                    queue.offer(treeNode);
                } else {
                    curNode.right = null;
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = TreeCommon.createNullEleTree(Arrays.asList(1,null,2));
        String treeStr = codec.serialize(root);
        codec.deserialize(treeStr);
    }
}
