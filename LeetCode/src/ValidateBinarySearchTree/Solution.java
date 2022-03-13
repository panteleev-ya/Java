package ValidateBinarySearchTree;

public class Solution {
    public static void main(String[] args) {
        Integer[] treeLayers = {5,4,6,null,null,3,7};
        TreeNode root = new TreeNode(
                5,
                new TreeNode(
                        4, null, null),
                new TreeNode(
                        6,
                        new TreeNode(
                                3, null, null),
                        new TreeNode(
                                7, null, null)));
        // TreeNode root = new TreeNode(5, new TreeNode(6), new TreeNode(4));
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // Так как это root - ограничений нет
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean helper(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }

        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }

        // Добавляем ограничения по максимальному и минимальному значению:
        // Слева все значения меньше, чем справа
        return helper(root.left, minValue, root.val) && helper(root.right, root.val, maxValue);
    }
}
