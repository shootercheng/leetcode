package com.scd.exercise.y2022.m3;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.Arrays;

/**
 * @author James
 */
public class Code606 {

    public String tree2str(TreeNode t) {
        StringBuilder stringBuilder = new StringBuilder("");
        travelTree(t, stringBuilder);
        return stringBuilder.toString();
    }

    private void travelTree(TreeNode t, StringBuilder stringBuilder) {
        if (t != null) {
            stringBuilder.append("(");
            if (stringBuilder.charAt(stringBuilder.length() - 1) == ')')
            stringBuilder.append(t.val);
            if (t.right == null) {
                stringBuilder.append(")");
            }
            travelTree(t.left, stringBuilder);
            System.out.println("1111");
            travelTree(t.right, stringBuilder);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeCommon.createNullEleTree(Arrays.asList(1,2,3,4));
        Code606 code606 = new Code606();
        System.out.println(code606.tree2str(treeNode));
    }
}
