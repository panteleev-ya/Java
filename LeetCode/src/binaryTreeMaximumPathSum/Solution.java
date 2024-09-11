package binaryTreeMaximumPathSum;

public class Solution {
    public static class TreeNode {
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

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return maxSum;
    }

    private int maxSum;

    private int gainFromSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int gainFromLeft = Math.max(gainFromSubtree(root.left), 0);
        int gainFromRight = Math.max(gainFromSubtree(root.right), 0);
        maxSum = Math.max(maxSum, gainFromLeft + gainFromRight + root.val);
        return Math.max(gainFromLeft + root.val, gainFromRight + root.val);
    }

    public static void main(String[] args) {
        // 1,-2,-3,1,3,-2,null,-1
        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        -2,
                        new TreeNode(
                                1,
                                new TreeNode(-1),
                                null
                        ),
                        new TreeNode(3)
                ),
                new TreeNode(
                        -3,
                        new TreeNode(-2),
                        null
                )
        );
        System.out.println(new Solution().maxPathSum(root));
    }
}
