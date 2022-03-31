package com.scd.exercise.y2021.m7;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author James
 */
public class Code863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<List<Integer>> pathList = new ArrayList<>();
        List<Integer> onePath = new ArrayList<>();
        preTraverse(root, pathList, onePath);
        Set<Integer> result = new HashSet<>();
        List<List<Integer>> notContainTargetList = new ArrayList<>();
        int dis = 0;
        for (List<Integer> path : pathList) {
            int lenp = path.size();
            int targetIndex = -1;
            for (int i = 0; i <lenp; i++) {
                if (path.get(i) == target.val) {
                    targetIndex = i;
                    break;
                }
            }
            if (targetIndex == -1) {
                notContainTargetList.add(path);
            } else {
                dis = targetIndex;
                if (targetIndex + k < path.size()) {
                    result.add(path.get(targetIndex + k));
                }
                if (targetIndex - k >= 0) {
                    result.add(path.get(targetIndex - k));
                }
            }
        }
        dis = k - dis;
        if (dis > 0) {
            for (List<Integer> path : notContainTargetList) {
                if (path.size() > dis) {
                    result.add(path.get(dis));
                }
            }
        }
        return new ArrayList<>(result);
    }

    private void preTraverse(TreeNode root, List<List<Integer>> pathList, List<Integer> onePath) {
        if (root != null) {
            List<Integer> list = new ArrayList<>(onePath);
            list.add(root.val);
            if (root.left == null && root.right == null) {
                pathList.add(list);
            }

            preTraverse(root.left, pathList, list);
            preTraverse(root.right, pathList, list);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeCommon.createNullEleTree(Arrays.asList(0,1,null,3,2));
        Code863 code863 = new Code863();
        code863.distanceK(treeNode, new TreeNode(2), 1);
    }
}
