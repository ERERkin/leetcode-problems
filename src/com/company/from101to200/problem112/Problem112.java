package com.company.from101to200.problem112;

public class Problem112 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(4,
                        new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8,
                        new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        int targetSum = 22;
        boolean answer = solution.hasPathSum(treeNode, targetSum);
        System.out.println(answer);
    }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum){
            return true;
        }
        if (root.left == null && root.right == null){
            return false;
        }
        boolean leftAnswer = hasPathSum(root.left, targetSum - root.val);
        boolean rightAnswer = hasPathSum(root.right, targetSum - root.val);
        return leftAnswer || rightAnswer;
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
