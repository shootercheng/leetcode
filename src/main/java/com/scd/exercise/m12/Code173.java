package com.scd.exercise.m12;

import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code173 {

    class BSTIterator {
        private int moveIndex = 0;

        private List<Integer> dataList = new ArrayList<>();

        public BSTIterator(TreeNode root) {
            traverseTree(root, dataList);
            dataList = dataList.stream().sorted().collect(Collectors.toList());
        }

        /** @return the next smallest number */
        public int next() {
            if (moveIndex >= dataList.size()) {
                throw new IllegalStateException("move index out of size");
            }
            int result = dataList.get(moveIndex);
            moveIndex++;
            return result;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return moveIndex < dataList.size();
        }

        private void traverseTree(TreeNode root, List<Integer> dataList) {
            if (root != null) {
                dataList.add(root.val);
                traverseTree(root.left, dataList);
                traverseTree(root.right, dataList);
            }
        }
    }
}
