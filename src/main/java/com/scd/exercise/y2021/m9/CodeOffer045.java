package com.scd.exercise.y2021.m9;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author James
 */
public class CodeOffer045 {

    class LevelTree {
        private TreeNode node;

        private Integer level;

        public LevelTree(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<LevelTree> queue = new ArrayDeque<>();
        LevelTree levelTree = new LevelTree(root, 1);
        queue.offer(levelTree);
        Map<Integer, List<LevelTree>> rowMap = new HashMap<>();
        int maxLevel = 0;
        while (!queue.isEmpty()) {
            LevelTree treeNode = queue.poll();
            if (treeNode.level > maxLevel) {
                maxLevel = treeNode.level;
            }
            List<LevelTree> levelTreeList = rowMap.computeIfAbsent(treeNode.level, k -> new ArrayList<>());
            levelTreeList.add(treeNode);
            int level = treeNode.level + 1;
            if (treeNode.node.left != null) {
                LevelTree leftLevelTree = new LevelTree(treeNode.node.left, level);
                queue.offer(leftLevelTree);
            }
            if (treeNode.node.right != null) {
                LevelTree rightLevelTree = new LevelTree(treeNode.node.right, level);
                queue.offer(rightLevelTree);
            }
        }
        return rowMap.get(maxLevel).get(0).node.val;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(
                1,2,3,4,null,5,6,null,null,7
        );
        TreeNode tree = TreeCommon.createBinaryTree(list);
        CodeOffer045 codeOffer045 = new CodeOffer045();
        System.out.println(codeOffer045.findBottomLeftValue(tree));
    }
}
