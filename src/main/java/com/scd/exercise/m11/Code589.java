package com.scd.exercise.m11;

import com.scd.exercise.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code589 {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            preorder(root, result);
        }
        return result;
    }

    private void preorder(Node root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            List<Node> childrenList = root.children;
            for (Node node : childrenList) {
                preorder(node, result);
            }
        }
    }
}
