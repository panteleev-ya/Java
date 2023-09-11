package Day17;

public class Solution {
    public static void main(String[] args) {
        final TreeNode target = new TreeNode(3, new TreeNode(6), new TreeNode(19));
        final TreeNode original = new TreeNode(7, new TreeNode(4), target);
        final TreeNode cloned = new TreeNode(7, new TreeNode(4), new TreeNode(3, new TreeNode(6), new TreeNode(19)));
        System.out.println(getTargetCopy(original, cloned, target));
    }

    private static TreeNode targetCopy;
    public static TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || target == null) {
            return null;
        }
        targetCopy = cloned;
        checkNode(targetCopy, target);
        return targetCopy;
    }

    private static void checkNode(TreeNode node, final TreeNode target) {
        boolean isValid = false;
        if (node.val == target.val) {
            if (node.left == null && target.left == null || (node.left != null && target.left != null && node.left.val == target.left.val)) {
                if (node.right == null && target.right == null || (node.right != null && target.right != null && node.right.val == target.right.val)) {
                    isValid = true;
                }
            }
        }
        if (isValid) {
            targetCopy = node;
        } else {
            if (node.left != null) {
                checkNode(node.left, target);
            }
            if (node.right != null) {
                checkNode(node.right, target);
            }
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
        TreeNode(int x, TreeNode left, TreeNode right) {
            val = x;
            this.left = left;
            this.right = right;
        }
    }
}
