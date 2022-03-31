package com.scd.exercise.m11;

import com.scd.exercise.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author James
 */
public class Code590 {

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node root, List<Integer> result) {
        if (root != null) {
            List<Node> childList = root.children;
            for (Node node : childList) {
                postorder(node, result);
            }
            result.add(root.val);
        }
    }
}
