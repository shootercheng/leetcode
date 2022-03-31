package com.scd.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class Code100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> pQueue = new ArrayDeque<>();
        Queue<TreeNode> qQueue = new ArrayDeque<>();
        pQueue.offer(p);
        qQueue.offer(q);
        while (!pQueue.isEmpty() || !qQueue.isEmpty()) {
            if (pQueue.size() != qQueue.size()) {
                return false;
            }
            TreeNode pNode = pQueue.poll();
            TreeNode qNode = qQueue.poll();
            if (pNode == null || qNode == null) {
                return false;
            }
            boolean valueSame = pNode.val == qNode.val;
            boolean leftSame = (pNode.left == null && qNode.left == null) ||
                               (pNode.left != null && qNode.left != null && pNode.left.val == qNode.left.val);
            boolean rightSame = (pNode.right == null && qNode.right == null) ||
                                (pNode.right != null && qNode.right != null && pNode.right.val == qNode.right.val);
            if (!(valueSame && leftSame && rightSame)) {
                return false;
            }
            if (pNode.left != null) {
                pQueue.offer(pNode.left);
            }
            if (pNode.right != null) {
                pQueue.offer(pNode.right);
            }
            if (qNode.left != null) {
                qQueue.offer(qNode.left);
            }
            if (qNode.right != null) {
                qQueue.offer(qNode.right);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11);
        Code100 code100 = new Code100();
        TreeNode root = TreeCommon.createTree(list);
        System.out.println(root);
        TreeNode p = TreeCommon.createTree(Arrays.asList(1,2,3));
        TreeNode q = TreeCommon.createTree(Arrays.asList(1,2,3));
        System.out.println(code100.isSameTree(p, q));
    }
}
