package PathSum;

public class Solution {
    public static void main(String[] args) {

    }

    private static int targetSum;
    private static boolean hasTargetSum;
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Solution.targetSum = targetSum;
        hasTargetSum = false;
        findTargetSum(root, root.val);
        return hasTargetSum;
    }

    private static void findTargetSum(TreeNode node, int sum) {
        if (hasTargetSum) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (sum == targetSum) {
                hasTargetSum = true;
            }
        } else {
            if (node.left != null) {
                findTargetSum(node.left, sum + node.left.val);
            }
            if (node.right != null) {
                findTargetSum(node.right, sum + node.right.val);
            }
        }
    }

//    private static int minDepthFound;
//    public static int minDepth(MinimumDepthOfBinaryTree.Solution.TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        minDepthFound = Integer.MAX_VALUE;
//        getMinDepth(root, 1);
//        return minDepthFound;
//    }
//
//    private static void getMinDepth(MinimumDepthOfBinaryTree.Solution.TreeNode node, int depth) {
//        if (node.left == null && node.right == null) {
//            if (minDepthFound > depth) {
//                minDepthFound = depth;
//            }
//        }
//
//        if (node.left != null) {
//            getMinDepth(node.left, depth + 1);
//        }
//
//        if (node.right != null) {
//            getMinDepth(node.right, depth + 1);
//        }
//    }

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
