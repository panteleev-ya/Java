package Day16;

public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                4,
                new TreeNode(
                        1,
                        new TreeNode(
                                0,
                                null,
                                null),
                        new TreeNode(
                                2,
                                null,
                                new TreeNode(
                                        3,
                                        null,
                                        null))
                        ),
                new TreeNode(
                        6,
                        new TreeNode(
                                5,
                                null,
                                null
                        ),
                        new TreeNode(
                                7,
                                null,
                                new TreeNode(
                                        8,
                                        null,
                                        null
                                )
                        )
                )
        );
        System.out.println(convertBST(root));
    }

    private static int sum = 0;
    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        calculateSum(root);
        sum = 0;
        return root;
    }
    public static void calculateSum(TreeNode node) {
        if (node.right != null) {
            calculateSum(node.right);
        }
        sum += node.val;
        node.val = sum;
        if (node.left != null) {
            calculateSum(node.left);
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
