package BalancedBinaryTree;

public class Solution {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(
//                1,
//                new TreeNode(
//                        2,
//                        new TreeNode(
//                                4,
//                                new TreeNode(8),
//                                null
//                        ),
//                        new TreeNode(5)
//                ),
//                new TreeNode(
//                        3,
//                        new TreeNode(6),
//                        null
//                )
//        );
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        return checkIfBalanced(root) != -1;
    }

    private static int checkIfBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubTreeHeight = checkIfBalanced(root.left);
        int rightSubTreeHeight = checkIfBalanced(root.right);
        if (leftSubTreeHeight == -1 || rightSubTreeHeight == -1 || Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
            return -1;
        }
        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
    }

    private static class TreeNode {
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
}
