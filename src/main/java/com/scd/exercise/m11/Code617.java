package com.scd.exercise.m11;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author James
 */
public class Code617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        List<Integer> list1 = createTreeList(t1);
        List<Integer> list2 = createTreeList(t2);
        List<Integer> resultList;
        if (list1.size() > list2.size()) {
            resultList = addTwoList(list1, list2);
        } else {
            resultList = addTwoList(list2, list1);
        }
        return convertListToTree(resultList);
    }

    private TreeNode convertListToTree(List<Integer> resultList) {
        Queue<TreeNode> queue = new LinkedList<>();
        Integer val = resultList.get(0);
        TreeNode root = new TreeNode(val);
        queue.offer(root);
        int size = resultList.size();
        int i = 1;
        int level = 1;
        while (i < size) {
            int num = (int) Math.pow(2, level);
            int tempLen = i + num;
            int j = i;
            while (j < tempLen) {
                TreeNode treeNode = queue.poll();
                if (treeNode != null) {
                    if (j >= size) {
                        break;
                    }
                    treeNode.left = resultList.get(j) != null ? new TreeNode(resultList.get(j)) : null;
                    j++;
                    queue.offer(treeNode.left);
                    if (j >= size) {
                        break;
                    }
                    treeNode.right = resultList.get(j) != null ? new TreeNode(resultList.get(j)) : null;
                    j++;
                    queue.offer(treeNode.right);
                } else {
                    queue.offer(null);
                    j++;
                    queue.offer(null);
                    j++;
                }
            }
            level++;
            i = tempLen;
        }
        return root;
    }

    private List<Integer> addTwoList(List<Integer> list1, List<Integer> list2) {
        int size = list2.size();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Integer ele1 = list1.get(i) == null ? 0 : list1.get(i);
            Integer ele2 = list2.get(i) == null ? 0 : list2.get(i);
            int sum = ele1 + ele2;
            if (sum != 0) {
                resultList.add(sum);
            } else {
                resultList.add(null);
            }

        }
        int longSize = list1.size();
        for (int i = size; i < longSize; i++) {
            resultList.add(list1.get(i));
        }
        return resultList;
    }

    private List<Integer> createTreeList(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            if (isAllNull(queue)) {
                break;
            }
            TreeNode curNode = queue.poll();
            if (curNode == null) {
                queue.offer(null);
                queue.offer(null);
                result.add(null);
            } else {
                queue.offer(curNode.left);
                queue.offer(curNode.right);
                result.add(curNode.val);
            }
        }
        return result;
    }

    private boolean isAllNull(Queue<TreeNode> queue) {
        Iterator<TreeNode> iterator = queue.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = TreeCommon.createBinaryTree(Arrays.asList(1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2));
        TreeNode root1 = TreeCommon.createBinaryTree(Arrays.asList(1,null,1,null,1,null,1,null,1,null,1,2));
        Code617 code617 = new Code617();
//        System.out.println(code617.createTreeList(root));
//        System.out.println(code617.createTreeList(root1));
        TreeNode result = code617.mergeTrees(root, root1);
        System.out.println(result);
    }
}
