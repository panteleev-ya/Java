package Day14;

public class Solution {
    public static void main(String[] args) {

    }
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            // Если нашли или такого нет - возвращаем
            return root;
        } else if (root.val > val) {
            // Если нужно меньше - налево
            return searchBST(root.left, val);
        } else {
            // Нужно больше - направо
            return searchBST(root.right, val);
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
