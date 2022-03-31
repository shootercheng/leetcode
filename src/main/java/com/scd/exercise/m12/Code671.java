package com.scd.exercise.m12;

import com.scd.exercise.TreeCommon;
import com.scd.exercise.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author James
 */
public class Code671 {

    public int findSecondMinimumValue(TreeNode root) {
        Set<Integer> valSet = new HashSet<>();
        preTraverseTree(root, valSet);
        if (valSet.size() < 2) {
            return -1;
        }
        List<Integer> keyList = valSet.stream().sorted().collect(Collectors.toList());
        return keyList.get(1);
    }

    private void preTraverseTree(TreeNode root, Set<Integer> dataSet) {
        if (root != null) {
            dataSet.add(root.val);
            preTraverseTree(root.left, dataSet);
            preTraverseTree(root.right, dataSet);
        }
    }

    public void findTwoNum(List<Integer> list, int[] nums) {
        for (Integer num : list) {
            if (num < nums[1]) {
                nums[1] = num;
                if (num < nums[0]) {
                    int temp = nums[0];
                    nums[0] = num;
                    nums[1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Code671 code671 = new Code671();
        List<Integer> list = Arrays.asList(1,4,5,4,6,7);
        int[] nums = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        code671.findTwoNum(list, nums);
        System.out.println(Arrays.toString(nums));
        TreeNode root = TreeCommon.createBinaryTree(Arrays.asList(2,2,5,null,null,5,5));
        System.out.println(code671.findSecondMinimumValue(root));
    }
}
