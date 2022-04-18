package Day18;

public class Solution {
    public static void main(String[] args) {

    }
    private static int id = 1;
    private static int value = -1;
    public int kthSmallest(TreeNode root, int k) {
        findValueByID(root, k);
        int result = value;
        value = -1;
        id = 1;
        return result;
    }
    private static void findValueByID(TreeNode root, int target) {
        if (root.left != null) {
            findValueByID(root.left, target);
        }
        if (id == target) {
            value = root.val;
            id++;
            return;
        }
        id++;
        if (root.right != null) {
            findValueByID(root.right, target);
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
