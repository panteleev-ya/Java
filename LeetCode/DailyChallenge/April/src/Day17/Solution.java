package Day17;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                5,
                new TreeNode(
                        3,
                        new TreeNode(
                                2,
                                new TreeNode(
                                        1,
                                        null,
                                        null
                                ),
                                null
                        ),
                        new TreeNode(
                                4,
                                null,
                                null
                        )
                ),
                new TreeNode(
                        6,
                        null,
                        new TreeNode(
                                8,
                                new TreeNode(
                                        7,
                                        null,
                                        null
                                ),
                                new TreeNode(
                                        9,
                                        null,
                                        null
                                )
                        )
                )
        );
        System.out.println(increasingBST(root));
    }
    private static TreeNode sortedTree;
    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        sortValues(root);
        TreeNode result = sortedTree;
        sortedTree = null;
        return result;
    }
    private static void sortValues(TreeNode root) {
        if (root.right != null) {
            sortValues(root.right);
        }
        sortedTree = new TreeNode(root.val, null, sortedTree);
        if (root.left != null) {
            sortValues(root.left);
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
