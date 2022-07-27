package Day27;

public class Solution {
    public static void main(String[] args) {

    }

    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right); //traverse till right most.
        flatten(root.left); //got to left of right most
        root.left = null; //set left as null
        root.right = prev; //set right to previously traversed node
        prev = root; //set prev to current node.
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
