package Day19;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(
                        1,
                        null,
                        null
                ),
                new TreeNode(
                        4,
                        new TreeNode(
                                2,
                                null,
                                null
                        ),
                        null
                )
        );
        recoverTree(root);
    }
    private static TreeNode prev;
    private static TreeNode left;
    private static TreeNode right;
    public static void recoverTree(TreeNode root) {
        parseBST(root);
        int tmp = left.val;
        left.val = right.val;
        right.val = tmp;
        prev = null;
        left = null;
        right = null;
    }
    private static void parseBST(TreeNode root) {
        if (root.left != null) {
            parseBST(root.left);
        }
        if (prev != null) {
            if (prev.val > root.val) {
                if (left == null) {
                    left = prev;
                }
                right = root;
            }
        }
        prev = root;
        if (root.right != null) {
            parseBST(root.right);
        }
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
