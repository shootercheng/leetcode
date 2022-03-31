package com.scd.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author James
 */
public class Code257_1 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resultList = new ArrayList<>();
        StringBuilder path = new StringBuilder("");
        dfsTraverseTree(root, path, resultList);
        return resultList;
    }

    private void dfsTraverseTree(TreeNode root, StringBuilder path, List<String> resultList) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                path.append(root.val);
                resultList.add(path.toString());
            } else {
                path.append(root.val).append("->");
            }
            dfsTraverseTree(root.left, new StringBuilder(path), resultList);
            dfsTraverseTree(root.right, new StringBuilder(path), resultList);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeCommon.createTree(Arrays.asList(1,2,3,4,5));
        Code257_1 code257 = new Code257_1();
        List<String> paths = code257.binaryTreePaths(treeNode);
        System.out.println(paths);
    }
}
