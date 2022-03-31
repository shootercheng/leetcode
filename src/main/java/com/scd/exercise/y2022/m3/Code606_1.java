package com.scd.exercise.y2022.m3;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.Arrays;

/**
 * @author James
 */
public class Code606_1 {

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
        }
        if (t.right == null) {
            return new StringBuilder().append(t.val).append("(").append(tree2str(t.left)).append(")").toString();
        }
        return new StringBuilder().append(t.val).append("(").append(tree2str(t.left))
                .append(")(").append(tree2str(t.right)).append(")").toString();
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeCommon.createNullEleTree(Arrays.asList(1,2,3,4));
        Code606_1 code6061 = new Code606_1();
        String res = code6061.tree2str(treeNode);
        System.out.println(res);
    }
}
