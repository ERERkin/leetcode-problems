package com.company.from601to700.problem653;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem653 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1, new TreeNode(0, new TreeNode(-2), null), new TreeNode(4, new TreeNode(7), null));
//        TreeNode treeNode = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        int k = 7;
        boolean answer = solution.findTarget(treeNode, k);
        System.out.println(answer);
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        fillList(root, list);
        list = list.stream().sorted().collect(Collectors.toList());
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (k - list.get(i) == list.get(j)){
                return true;
            }else if (k - list.get(i) > list.get(j)){
                i++;
            }else{
                j--;
            }
        }
        System.out.println(list);
        return false;
    }

    void fillList(TreeNode treeNode, List<Integer> list) {
        if (treeNode == null) return;
        list.add(treeNode.val);
        fillList(treeNode.left, list);
        fillList(treeNode.right, list);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

