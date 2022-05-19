package MinimumDepthOfBinaryTree;

public class Solution {
    public static void main(String[] args) {

    }

    private static int minDepthFound;
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDepthFound = Integer.MAX_VALUE;
        getMinDepth(root, 1);
        return minDepthFound;
    }

    private static void getMinDepth(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            if (minDepthFound > depth) {
                minDepthFound = depth;
            }
        }

        if (node.left != null) {
            getMinDepth(node.left, depth + 1);
        }

        if (node.right != null) {
           getMinDepth(node.right, depth + 1);
        }
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
